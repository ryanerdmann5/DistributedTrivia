import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;




public class TriviaClient 
{
	int port_number;
	InetAddress address;
	Socket client_socket;
	PrintWriter output;
	BufferedReader input;
	String userResponse;
	
	
	

	public TriviaClient(int port) throws IOException
	{
		port_number = port;
		address=InetAddress.getLoopbackAddress();
		client_socket = new Socket(address, port_number);
		output = new PrintWriter(client_socket.getOutputStream(), true);
		input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
	}

	public void receiveQuestions() throws IOException, InterruptedException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int turns=Integer.parseInt(input.readLine());
		System.out.println(turns+" turn game");
		for(int i=0;i<turns;i++){
			//System.out.println("While loop");
			System.out.println("Category: "+input.readLine());
			//reads question
			System.out.println(input.readLine());
			
			// if we wanted to put a timer, this is the place for it
						
			String answer = in.readLine();
			answerQuestion(answer);

		}
		System.out.println(input.readLine()); 
	}

	public void answerQuestion(String answer) throws IOException{
		//writes to PrintWriter
		output.println(answer);
		//Gets response about it's answer (correct/incorrect)
		System.out.println(input.readLine());
	}
	
	/*
	public void newGameStarted() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(input.readLine());
		String response = in.readLine();
		output.println(response);

		System.out.println(input.readLine());
		
		if (!response.equals("yes")) {
			close();
		} else {
			output.println(in.readLine());
		}
	}
 */

	void close()
	{
		try
		{ 
			System.out.println("Closing Client");
			client_socket.close();
		}
		catch(Exception e){}
	}	

	/*public static void main(String[] args){
		if(args.length != 1){
			System.err.println("Port number argument missing");
			System.err.println("Usage:java TriviaClient(portNumber");
		} else{
			try{
				//starts client
				TriviaClient client = new TriviaClient(Integer.parseInt(args[0]));
				//recieve questions in the form of while loop
				client.recieveQuestions();
				//

			} catch(IOException e){
				e.getMessage();
			}
		}
	}*/

}

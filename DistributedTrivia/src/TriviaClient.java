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
		client_socket = new Socket(address, port_number);
		output = new PrintWriter(client_socket.getOutputStream(), true);
		input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
	}
	
	
	public void recieveQuestions() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(input.readLine() != null){
			//reads question
			input.readLine();
			//standard input answer
			String answer = in.readLine();
			answerQuestion(answer);
			
		}
	}

	public void answerQuestion(String answer) throws IOException{
		//writes to PrintWriter
		output.println(answer);
		//Gets response about it's answer (correct/incorrect)
		input.readLine();
	}
	
	void close()
	{
		try
			{ 
			System.out.println("Closing Client");
			client_socket.close();
			}
		catch(Exception e){}
	}
	
	public static void main(String[] args){
		if(args.length != 1){
			System.err.println("Port number argument missing");
			System.err.println("Usage: TriviaClient(portNumber");
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
	}
	
}

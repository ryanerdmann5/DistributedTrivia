
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TriviaServer {

	int port_number;
	ServerSocket server_socket;
	Socket client_socket;
	BufferedReader input;
	PrintWriter output;
	
	int score;
	private String[] categories={"SportsAndLeisure", "History", "Geography", "Entertainment", "ArtsAndLit", "ScienceAndNature"};
	private boolean gameRunning=false;
	int turns;
	
	public TriviaServer(int port, int turns) throws IOException
	{
			this.turns=turns;
			port_number = port;
			server_socket = new ServerSocket(port_number);
			System.out.println(port_number);
			client_socket = server_socket.accept();
			input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
			output = new PrintWriter(client_socket.getOutputStream(), true);
			QuestionReader qr=new QuestionReader("Questions.csv");
			qr.readFile();
	}
	
	
	public void askQuestions() throws InterruptedException, IOException{
		int category;
		Random rn = new Random();
		String Question = null;
		QuestionManager qm = QuestionManager.getInstance();
		Question q;
		String answer;
		output.println(turns);
		for (int i = 0; i < turns; i++) {
			category = rn.nextInt(5 - 0 + 1) + 0;
			//System.out.println(category);
			q=qm.getQuestionFrom(categories[category]);
			output.println(q.returnQuestion());
			// wait for response
			answer=input.readLine();
			//hardcoded A for now, will have to change
			if(answer.equals("A")||answer.equals("a")){
				score=score++;
				output.println("That's correct!");
			}
			//again, hardcoded A
			else{
				output.println("The correct answer was"+"A");
			}
			
			// calculate scores
		}
		output.println(score);
		gameRunning=false;
		close();
	}
	
	
	
	
	
	void close()
	{
		try
		{
			client_socket.close();
			System.out.print("**Closing Server**");
			server_socket.close();
		}
		catch(Exception e){}
	}
	
	
	
	
	
}

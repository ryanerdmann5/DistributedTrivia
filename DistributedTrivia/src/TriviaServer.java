// Ryan Erdmann
// Hannah Corrello

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

	Double difference;

	Double score;
	private String[] categories = {"SportsAndLeisure", "History", "Geography", "Entertainment", "ArtsAndLit", "ScienceAndNature"};
	//private boolean gameRunning =false;
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
		QuestionReader qr=new QuestionReader("q.csv");
		qr.readFile();
	}


	public void askQuestions() throws InterruptedException, IOException{
		int category;
		Random rn = new Random();
		//String Question = null;
		QuestionManager qm = QuestionManager.getInstance();
		Question q;
		String answer = null;
		output.println(turns);
		score=0.0;
		for (int i = 0; i < turns; i++) {
			//gameRunning = true;
			category = rn.nextInt(5 - 0 + 1) + 0;
			//category = rn.nextInt(5);
			//System.out.println(category);
			output.println(categories[category]);
			q=qm.getQuestionFrom(categories[category]);
			//System.out.println("sending question");
			output.println(q.returnQuestion());
			//wait for response
			long beginTime = System.nanoTime();
			
			answer=input.readLine();
			long endTime = System.nanoTime();

			long totalTime = endTime - beginTime;
			Double timeElapsed = (double) (totalTime / 10000000);

			if(q.checkAnswer(answer)){
				// calculates scores based on duration 
				Double scoreToAdd;
				// less than 2 seconds
				if (timeElapsed < 200) {
					scoreToAdd = 1.75;
					
				} // less than 3 seconds
				else if (timeElapsed < 300) {
					scoreToAdd = 1.5;
					
				} // less than 5 seconds
				else if (timeElapsed < 500) {
					scoreToAdd = 1.25;
					
				} // over 30 seconds
				else if (timeElapsed > 30000){
					System.out.println("Took more than 30 seconds to answer");
					scoreToAdd = 0.5;
					
				} // between 5 and 30 seconds
				else {
					scoreToAdd = 1.0;
				}
				score=score+scoreToAdd;
				System.out.println("Added: "+scoreToAdd);
				System.out.println("Current score: "+score);
				output.println("That's correct!");
			}
			
			else {
				System.out.println("Wrong. 0 points awarded.");
				System.out.println("Current score: "+score);
				output.println("Incorrect! The correct answer was "+q.getAnswer());
			}

			// calculate scores
		}
		System.out.println("Final Score: "+score);
		output.println("Final Score: "+score);
		//gameRunning=false;
		//startNewGame();
		close();
	}

	/*
	public void startNewGame() throws InterruptedException, IOException
	{
		System.out.println("Asking if client wants to start new game");
		output.println("Would you like to start a new game? (yes/no) ");

		String NG = input.readLine();

		if (NG != null)
		{
			if (NG.equals("yes"))
			{
				//Scanner scanner2 = new Scanner(System.in);
				output.println("How many questions would you like? (1-60) ");
				String NewG = input.readLine();

				int y = Integer.parseInt(NewG);
				if (y >= 1 && y <= 60) 
				{
					try{
						client_socket.close();
						server_socket.close();
						TriviaServer ts = new TriviaServer(port_number+1, y);
						TriviaClient client = new TriviaClient(port_number+1);

						ts.askQuestions();

						client.receiveQuestions();
						client.newGameStarted();

					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {
					close();
				}
			} else {
				System.out.println("Thanks for playing! Goodbye.");
				output.println("Thanks for playing! Goodbye.");
				close();
			}

		}

	} */


	void close()
	{
		try
		{
			client_socket.close();
			System.out.println("**Closing Server**");
			server_socket.close();
		}
		catch(Exception e){}
	}





}

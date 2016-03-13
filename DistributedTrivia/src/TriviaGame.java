//Ryan Erdmann

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TriviaGame {
	private int turns;
	private ArrayList<Integer> players = new ArrayList<Integer>();
	//private boolean gameRunning = false;
	private String[] categories={"SportsAndLeisure", "History", "Geography", "Entertainment", "ArtsAndLit", "ScienceAndNature"};

	/**
	 * Sets up the TriviaGame class
	 * 
	 * @param turns the number of turns you would like the game to play.
	 */
	public TriviaGame(int turns) {
		this.turns = turns;
	}

	// passing the id as an int now, we can reconfig later
	/**
	 * Add a player to the list for when we check for answers
	 * 
	 * @param id Will be an IP address once we make this distributed 
	 */
	public void addPlayer(int id) {
		players.add(id);
	}

	/**
	 * Start the game and calls ask question
	 * 
	 * @throws InterruptedException
	 */
	public void startGame() throws InterruptedException {
		//gameRunning = true;
		askQuestion();
	}

	/**
	 * Asks a question the number of times indicated in the constructor
	 * @throws InterruptedException
	 */
	public void askQuestion() throws InterruptedException {
		int category;
		Random rn = new Random();
		//String Question = null;
		QuestionManager qm = QuestionManager.getInstance();
		Question q;
		for (int i = 0; i < turns; i++) {
			category = rn.nextInt(5 - 0 + 1) + 0;
			//System.out.println(category);
			q=qm.getQuestionFrom(categories[category]);
			System.out.println(q.returnQuestion());
			// wait for response
			Thread.sleep(30000);
			// calculate scores
		}
		//gameRunning=false;
	} 
	
	/**
	 * for testing
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		if(args.length==0||args.length>2){
			System.out.println("How to play: You will be given a series of questions to answer. "
					+ "Answer them to the best of your knowledge. "
					+ "The faster you answer, the better your score will be. "
					+ "Good luck!");
			System.out.println("Usage: ");
			System.out.println("As server: java TriviaGame <port> <# of turns>");
			System.out.println("As client: java TriviaGame <port>");
		}
		if(args.length==2){
			int port=Integer.parseInt(args[0]);
			int turns=Integer.parseInt(args[1]);
			TriviaServer ts=new TriviaServer(port,turns);
			ts.askQuestions();
	        
	        
			
		}
		if(args.length==1){
			TriviaClient client = new TriviaClient(Integer.parseInt(args[0]));
			//recieve questions in the form of while loop
			//client.receiveInstructions();
			client.receiveQuestions();
		}
		
		
		/*
		QuestionReader qr=new QuestionReader("C:\\Users\\Ryan\\Desktop\\temp\\Questions.csv");
=======
			//TriviaClient();
			int port=Integer.parseInt(args[0]);
			TriviaClient tc = new TriviaClient(port);
			tc.recieveQuestions();
		}
		QuestionReader qr=new QuestionReader("q.csv");
>>>>>>> Stashed changes
		qr.readFile();
		TriviaGame tg = new TriviaGame(5);
		tg.startGame();
		 */
	}

}

//Ryan Erdmann

import java.util.ArrayList;
import java.util.Random;

public class TriviaGame {
	private int turns;
	private ArrayList<Integer> players = new ArrayList<Integer>();
	private boolean gameRunning = false;

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
		gameRunning = true;
		askQuestion();
	}

	/**
	 * Asks a question the number of times indicated in the constructor
	 * @throws InterruptedException
	 */
	public void askQuestion() throws InterruptedException {
		int category;
		Random rn = new Random();
		String Question = null;
		QuestionManager qm = new QuestionManager();
		for (int i = 0; i <= turns; i++) {
			category = rn.nextInt(6 - 0 + 1) + 0;
			System.out.println(category);
			// Question=qm.getQuestionFrom(category);
			System.out.println(Question);
			// wait for response
			Thread.sleep(30000);
			// calculate scores
		}
		gameRunning=false;
	}
	
	public int calculateScore(){
		return 0;
	}

	/**
	 * for testing
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

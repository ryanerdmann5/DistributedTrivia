import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Question {
	
	//create global variables to be easily accessed for the following:
	// question, topic, answer a/b/c/d, answer given by user, count for correct answers
	public static String question;
	public static String topic;
	public static String answerA;
	public static String answerB;
	public static String answerC;
	public static String answerD;
	public static String userAnswer;
	public static int count = 0;
	
	public Question(String QuestionText, String topic, String answerA, String answerB, String answerC){
		
	}
	
	
	public static void NumQuestion(int turns)
	{
		//in main class args will be how many questions long the game will be; for now its a fill in
		int numOfQuestions = turns;
		System.out.println("There will be " + numOfQuestions + " questions in this game...");
	}
	
	//go into excel file and get the needed information from the table and place
	//in the appropriate variable
			// also can use questionReader since it already gets the questions, just place in the variables
			//right now doesn't do anything
	QuestionReader reader = new QuestionReader("qs.csv");
	
	
	public static void returnQuestion(){
		//display question
		System.out.println("Topic: History"); //Question Topic
		System.out.println("This is your question:"); //Question
		System.out.println("     A: "); //AnswerA
		System.out.println("     B: "); //AnswerB
		System.out.println("     C: "); //AnswerC
		System.out.println("     D: "); //AnswerD
		
		//Get user answer
		Scanner scanner = new Scanner(System.in);
		System.out.print("Which do you think is correct? Please type A/B/C/D: ");

		userAnswer = scanner.next();
		
		//check if answer is correct if 
		if(userAnswer != null){
			if (userAnswer.equals("A")){
			System.out.println(userAnswer + " was inputed.");
			return;
			}
			else 
				System.out.println(userAnswer + " was inputed instead.");
		}
		else
		{
			//close game, will be closed more gracefully with client/server
			System.out.println("No input was detected or wrong input entered. Game will be terminated.");
			System.out.println("Goodbye");
			System.exit(0);	
			
		}
				
	}
	
	
	//can be removed. For test purposes only.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumQuestion(10);
		returnQuestion();
		
	}

}

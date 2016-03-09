import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question {
	
	//create global variables to be easily accessed for the following:
	// question, topic, answer a/b/c/d, answer given by user, count for correct answers
	public String question;
	public String answerA;
	public String answerB;
	public String answerC;
	public String answerD;
	public String userAnswer;
	public int count = 0;
	private ArrayList<String> questionList=new ArrayList<String>();
	
	public Question(String QuestionText, String answerA, String answerB, String answerC, String answerD){
		this.question=QuestionText;
		this.answerA=answerA;
		this.answerB=answerB;
		this.answerC=answerC;
		this.answerD=answerD;
		questionList.add(answerA);
		questionList.add(answerB);
		questionList.add(answerC);
		questionList.add(answerD);
		Collections.shuffle(questionList);
		
		
		
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
	//QuestionReader reader = new QuestionReader("qs.csv");
	
	
	public String returnQuestion(){
		//display question
		/*
		System.out.println("Topic:"); //Question Topic
		System.out.println("This is your question:"+ this.question); //Question
		System.out.println("     A: "+this.answerA); //AnswerA
		System.out.println("     B: "+this.answerB); //AnswerB
		System.out.println("     C: "+this.answerC); //AnswerC
		System.out.println("     D: "+this.answerD); //AnswerD
		*/
		return ("Question: "+this.question+" A: "+questionList.get(0)+" B: "+questionList.get(1)+
				" C: "+questionList.get(2)+" D: "+questionList.get(3));
		
		
				
	}
	
	public boolean checkAnswer(String answer){
		if(answer.equals("A")||answer.equals("a")){
			if(questionList.get(0).equals(answerA))return true;
			return false;
		}
		
		if(answer.equals("B")||answer.equals("b")){
			if(questionList.get(1).equals(answerA))return true;
			return false;
		}
		
		if(answer.equals("C")||answer.equals("c")){
			if(questionList.get(2).equals(answerA))return true;
			return false;
		}
		if(answer.equals("D")||answer.equals("d")){
			if(questionList.get(3).equals(answerA))return true;
			return false;
		}
		return false;
	}
	
	public String getAnswer(){
		if(questionList.get(0).equals(answerA))return "A";
		if(questionList.get(1).equals(answerA))return "B";
		if(questionList.get(2).equals(answerA))return "C";
		if(questionList.get(3).equals(answerA))return "D";
		return"error";
	}
	


}

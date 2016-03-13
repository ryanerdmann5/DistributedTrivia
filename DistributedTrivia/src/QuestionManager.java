import java.util.ArrayList;
import java.util.Collections;

public class QuestionManager {
	//ArrayList<Question> SportsAndLeisure, History, Geography, Entertainment, ArtsAndLit, ScienceAndNature;
	ArrayList<Question> ArtsAndLit=new ArrayList<Question>();
	ArrayList<Question> History=new ArrayList<Question>();
	ArrayList<Question> Geography=new ArrayList<Question>();
	ArrayList<Question> Entertainment=new ArrayList<Question>();
	ArrayList<Question> SportsAndLeisure=new ArrayList<Question>();
	ArrayList<Question> ScienceAndNature=new ArrayList<Question>();
	
	private static final QuestionManager instance =new QuestionManager();
	
	private QuestionManager(){
		//Don't think we really need anything besides the ArrayLists 
	}
	
	public static QuestionManager getInstance(){
		return instance;
	}
	

	//just passes the Question and category as a string
	
	// added return statements to fix the bug of getting the same question twice
	public void addQuestionTo(Question q, String list){
		switch(list){
		case "SportsAndLeisure":
			SportsAndLeisure.add(q);
			return;
		case "History":
			History.add(q);
			return;
		case "Geography":
			Geography.add(q);
			return;
		case "Entertainment":
			Entertainment.add(q);
			return;
		case "ArtsAndLit":
			ArtsAndLit.add(q);
			return;
		case "ScienceAndNature":
			ScienceAndNature.add(q);
			return;
		}


	}
	
	
	public Question getQuestionFrom(String category){
		System.out.println(category);
		//The getQuestionFrom returns a question of type Question
		//from the appropiate list that was given in the parameters
		switch(category){
		case "SportsAndLeisure":
			//System.out.println(SportsAndLeisure.size());
			if(SportsAndLeisure.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Collections.shuffle(SportsAndLeisure);
				Question newQ = SportsAndLeisure.get(0);
				SportsAndLeisure.remove(newQ);
				return newQ;
			}
		case "History":
			//System.out.println(History.size());
			if(History.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Collections.shuffle(History);
				Question newQ = History.get(0);
				History.remove(newQ);
				return newQ;
			}
			
		case "Geography":
			//System.out.println(Geography.size());
			if(Geography.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Collections.shuffle(Geography);
				Question newQ = Geography.get(0);
				Geography.remove(newQ);
				return newQ;
			}
		case "Entertainment":
			//System.out.println(Entertainment.size());
			if(Entertainment.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Collections.shuffle(Entertainment);
				Question newQ = Entertainment.get(0);
				Entertainment.remove(newQ);
				return newQ;
			}
		case "ArtsAndLit":
			//System.out.println(ArtsAndLit.size());
			if(ArtsAndLit.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Collections.shuffle(ArtsAndLit);
				Question newQ = ArtsAndLit.get(0);
				ArtsAndLit.remove(newQ);
				return newQ;
			}
		case "ScienceAndNature":
			//System.out.println(ScienceAndNature.size());
			if(ScienceAndNature.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Collections.shuffle(ScienceAndNature);
				Question newQ = ScienceAndNature.get(0);
				ScienceAndNature.remove(newQ);
				return newQ;
			}
			
		}
		
		return null;
	}
	
	
}

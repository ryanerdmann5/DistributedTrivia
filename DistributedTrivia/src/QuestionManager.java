import java.util.ArrayList;

public class QuestionManager {
	ArrayList<Question> SportsAndLeisure, History, Geography, Entertainment, ArtsAndLit, ScienceAndNature;

	public QuestionManager(){
		//Don't think we really need anything besides the ArrayLists 
	}
	
	//Should the Question Manager add the questions itself or have
	//the questionReader do it since it is already going through all of the
	//questions and knows the categorys
	//just passes the Question and category as a string
	public void addQuestionTo(Question q, String list){
		switch(list){
		case "SportsAndLeisure":
			SportsAndLeisure.add(q);
		case "History":
			History.add(q);
		case "Geography":
			Geography.add(q);
		case "Entertainment":
			Entertainment.add(q);
		case "ArtsAndLit":
			ArtsAndLit.add(q);
		case "ScienceAndNature":
			ScienceAndNature.add(q);
		}
	}
	
	
	public Question getQuestionFrom(String category){
		//The getQuestionFrom returns a question of type Question
		//from the appropiate list that was given in the parameters
		switch(category){
		case "SportsAndLeisure":
			if(SportsAndLeisure.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Question newQ = SportsAndLeisure.get(0);
				SportsAndLeisure.remove(0);
				return newQ;
			}
		case "History":
			if(History.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Question newQ = History.get(0);
				History.remove(0);
				return newQ;
			}
		case "Geography":
			if(Geography.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Question newQ = Geography.get(0);
				Geography.remove(0);
				return newQ;
			}
		case "Entertainment":
			if(Entertainment.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Question newQ = Entertainment.get(0);
				Entertainment.remove(0);
				return newQ;
			}
		case "ArtsAndLit":
			if(ArtsAndLit.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Question newQ = ArtsAndLit.get(0);
				ArtsAndLit.remove(0);
				return newQ;
			}
		case "ScienceAndNature":
			if(ScienceAndNature.isEmpty()){
				return null;
				//return some error of this list is empty request a new one
			} else{
				//For now gets the first element
				//can later add an int randomizer within length range
				Question newQ = ScienceAndNature.get(0);
				ScienceAndNature.remove(0);
				return newQ;
			}
			
		}
		
		return null;
	}
	
	
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionReader {
	
	String filename;
	ArrayList<String> responses;
	
	public QuestionReader(String filename) {
		this.filename = filename;
		
	}
	
	public void readFile() throws FileNotFoundException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(filename)); 
		String line = br.readLine();
		QuestionManager qm=QuestionManager.getInstance();
		Question q;
		String question; 
		String correctAns; 
		String incorrectOne;
		String incorrectTwo;
		String incorrectThree;
		String category;
		while ((line = br.readLine()) != null && !line.isEmpty()) { 
			String[] fields = line.split(","); 
			//String qID = fields[0]; 
			question = fields[0]; 
			correctAns = fields[1]; 
			incorrectOne = fields[2];
			incorrectTwo = fields[3];
			incorrectThree = fields[4];
			category = fields[5];
			//System.out.println(question+category);
			if(category.equals("Arts & Literature")) category="ArtsAndLit";
			if(category.equals("Sports & Leisure")) category="SportsAndLeisure";
			if(category.equals("Science & Nature")) category="ScienceAndNature";
			q=new Question(question, correctAns, incorrectOne, incorrectTwo, incorrectThree);
			qm.addQuestionTo(q, category);
			
			
			// could also add these items to a HashMap or array
			//System.out.println("["+category+"] " + question);

		}
		//for(Question q1: qm.ArtsAndLit)q1.returnQuestion();
		
		br.close();
	}

}

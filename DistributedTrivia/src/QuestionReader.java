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
		while ((line = br.readLine()) != null && !line.isEmpty()) { 
			String[] fields = line.split(","); 
			String qID = fields[0]; 
			String question = fields[1]; 
			String correctAns = fields[2]; 
			String incorrectOne = fields[3];
			String incorrectTwo = fields[4];
			String incorrectThree = fields[5];
			String category = fields[6];
			
			
			// could also add these items to a HashMap or array
			//System.out.println("["+category+"] " + question);

		}
		
		br.close();
	}

	// can obviously be deleted
	public static void main(String[] args) throws FileNotFoundException, IOException {
		QuestionReader reader = new QuestionReader("qs.csv");
		reader.readFile();
		
		
			
			
		

	}

}

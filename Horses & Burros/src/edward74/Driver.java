package edward74;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
// Driver for the herd management program.
/**
 * @author Ryan Edwards
 * @version 4.15.2020
 */
public class Driver {

	public static void main(String[] args) {
		
		BufferedReader buff = new BufferedReader(file);
		DataSet animalInfo = new DataSet();
		
		
	}
	
	/**
	 * Method to load statistics from the file. Places each
	 * row of data into a state with proper attributes.
	 * 
	 * @param data
	 * @param file
	 * @param numRows
	 * @throws IOException 
	 */
	public void loadStatistics(DataSet data, Reader file, int numRows) throws IOException {
		// Opening a buffered reader and instantiating a state's data
				BufferedReader buffer = new BufferedReader(file);
				StateStatistic state = new StateStatistic();
				
				String line;
				int i = 0;
				String delim = "[,]";
		 		String[] tokens = buffer.readLine().split(delim);
				
		 		// Get to fourth line to begin taking data
				do {
					line = buffer.readLine();
					i++;
				} while (i < 3);
				
				// taking data from each line
				for (i = 0; i < tokens.length; i++) {
		 		    
		 		}
		return;
	}
	
	/**
	 * Method to display statistics for each state
	 */
	public void displayStatistics() {
		
		
	}

}

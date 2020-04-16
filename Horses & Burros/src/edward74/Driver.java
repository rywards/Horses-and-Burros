package edward74;

import java.io.Reader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Driver for the herd management program.
/**
 * @author Ryan Edwards
 * @version 4.15.2020
 */
public class Driver {

	public static void main(String[] args) throws IOException {
		
		// Setting up classes 
		DataSet animalInfo = new DataSet();
		Reader herdManagement = new FileReader("herdManagement.csv");
		loadStatistics(animalInfo, herdManagement, 7);
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
	public static void loadStatistics(DataSet data, Reader file, int numRows) throws IOException {
		
		// Opening a buffered reader and instantiating a state's data
				BufferedReader buffer = new BufferedReader(file);
				
				String line = buffer.readLine();
				int i = 0;
				String delim = "[,]";
		 		String[] tokens = buffer.readLine().split(delim);
				
		 		// TODO: count first line commas to get number of header rows. Temp code.
				do {
					line = buffer.readLine();
					i++;
				} while (i < 0);
				
				while (line != null) {
					line = buffer.readLine();
					
					if (line == null) {
						break;
					}
					System.out.println(line);
				}
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

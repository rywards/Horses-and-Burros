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
	 * row of data into a state with proper things.
	 * 
	 * @param data
	 * @param file
	 * @param numRows
	 * @throws IOException 
	 */
	public static void loadStatistics(DataSet data, Reader file, int numRows) throws IOException {
		
		// Opening a buffered reader and instantiating a state's data
				BufferedReader buffer = new BufferedReader(file);
				
			while (buffer != null) {
				StateStatistic stateStat = new StateStatistic();
				
				String line = buffer.readLine();
				String delim = "[,]";
		 		String[] tokens = line.split(delim);
				
		 		for (int i = 0; i < tokens.length; i++) {
		 			stateStat.setState(State.valueOf());
		 			stateStat.setHerdAreaAcresBLM(herdAreaAcresBLM);
		 			stateStat.setHerdAreaAcresOther(herdAreaAcresOther);
		 			stateStat.setHerdManagementAreaAcresBLM(herdManagementAreaAcresBLM);
		 			stateStat.setHerdManagementAreaAcresOther(herdManagementAreaAcresOther);
		 			stateStat.setNumHorses(numHorses);
		 			stateStat.setNumBurros(numBurros);
		 		}
	
			}
		 		
		return;
	}
	
	/**
	 * Method to display statistics for each state
	 */
	public void displayStatistics() {
		
		
	}

}

package edward74;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * Driver for the Herd Management program
 * @author Ryan Edwards
 * @version 4.15.2020
 */
public class Driver {

	public static void main(String[] args) throws IOException {
		
		// Setting up classes 
		DataSet animalInfo = new DataSet();
		Reader herdManagement = new FileReader("herdManagement.csv");
		loadStatistics(animalInfo, herdManagement, 7);
		animalInfo.displayStatistics(animalInfo.getStats());
		serialize(animalInfo);
		
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
		
		int i = 0;
		
		// Goes through each line of file
		while (buffer != null) {
			
			String line = buffer.readLine();
			if (line == null) {
				break;
			}
				
		 	// Skipping header rows and getting to data
		 	while (i < 3) {
		 		line = buffer.readLine();
		 		i++;
		 	}
		 		
		 	String delim = "[,]";
		 	String[] tokens = line.split(delim);
		 	
		 	// Note to self: had to put inside of loop to create fresh instance
		 	StateStatistic stateStat = new StateStatistic();
		 	
		 	data.addStatistic(stateStat);
		 	stateStat.setState(State.valueOf(tokens[0]));
		 	stateStat.setHerdAreaAcresBLM(Long.parseLong(tokens[1]));
		 	stateStat.setHerdAreaAcresOther(Long.parseLong(tokens[2]));
		 	stateStat.setHerdManagementAreaAcresBLM(Long.parseLong(tokens[3]));
			stateStat.setHerdManagementAreaAcresOther(Long.parseLong(tokens[4]));
	 		stateStat.setNumHorses(Long.parseLong(tokens[5]));
	 		stateStat.setNumBurros(Long.parseLong(tokens[6]));
	
			}
		 		
		return;
	}
	
	/**
	 * Serializes the dataset
	 * @param data
	 */
	public static void serialize(DataSet data) {
		
		// Serialization try catch block
			try {
				 FileOutputStream fileOut =
				  new FileOutputStream("HerdManagement.ser");
				  ObjectOutputStream out = new ObjectOutputStream(fileOut);
				  out.writeObject(data);
				  out.close();
				  fileOut.close();
		          System.out.printf("Serialized data is saved in /(yourJavaProject)/HerdManagement.ser");
					         
					      } catch (IOException i) {
					         i.printStackTrace();
					      }
			
	}
	
	public static void deserialize() {
		
	}
	

}

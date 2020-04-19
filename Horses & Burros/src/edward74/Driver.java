package edward74;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Driver for the Herd Management program
 * @author Ryan Edwards
 * @version 4.19.2020
 */
public class Driver {

	public static int NUM_HEADER_ROWS = 3;
	public static int MAX_DATA_INDEX = 9;
	public static int MIN_DATA_INDEX = 0;
	public static void main(String[] args) throws IOException {
		
		// Setting up classes 
		int dataToSerialize;
		DataSet animalInfo = new DataSet();
		String stateData = "src/herdManagement.csv";
		
		try {
			Reader herdManagement = new FileReader(stateData);
			
		} catch (FileNotFoundException f) {
			throw new StatisticDataNotFoundException(stateData);
		}
		Reader herdManagement = new FileReader(stateData);
		
		
		loadStatistics(animalInfo, herdManagement, NUM_HEADER_ROWS);
		animalInfo.displayStatistics(animalInfo.getStats());
		serialize(animalInfo.getStats().get(randStateData(MIN_DATA_INDEX, MAX_DATA_INDEX)));
		deserialize(animalInfo.getStats());
		
	}
	
	/**
	 * Method to load statistics from the file. Places each
	 * row of data into a state with proper information.
	 * 
	 * @param data
	 * @param file
	 * @param numRows
	 * @throws IOException 
	 * @author Ryan Edwards
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
		 	while (i < numRows) {
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
	 * Serializes the given statistic dataset.
	 * @param statistic
	 */
	public static void serialize(Statistic statistic) {
		
		// Serialization try catch block
			try {
				
				 FileOutputStream fileOut =
				  new FileOutputStream("HerdManagement.ser");
				  ObjectOutputStream out = new ObjectOutputStream(fileOut);
				  out.writeObject(statistic);
				  out.close();
				  fileOut.close();
					         
			 } catch (IOException i) {
				 
				 i.printStackTrace();
				 
			 }
			
	}
	
	/**
	 * Deserializes a statistic from a file and prints out
	 * the number of horses and burros in the corresponding 
	 * serialized state data.
	 * @param stats
	 * 
	 */
	public static void deserialize(ArrayList<Statistic> stats) {
		
		// Deserialization process.
		Statistic stat = null;
		StateStatistic stateStats = (StateStatistic) stat;
	      try {
	    	  
	         FileInputStream fileIn = new FileInputStream("HerdManagement.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         stateStats = (StateStatistic) in.readObject();
	         in.close();
	         fileIn.close();
	         
	      } 
	      catch (IOException i) {
	    	  
	         i.printStackTrace();
	         return;
	         
	      } catch (ClassNotFoundException c) {
	    	  
	         System.out.println("State info class not found.\n");
	         c.printStackTrace();
	         return;
	      } 
	      
	      
	     System.out.printf("There are %s burros and %s horses in %s\n", stateStats.getNumBurros(),
	    		 														 stateStats.getNumHorses(),
	    		 														 stateStats.getState()); 
	}
	
	/**
	 * Method to choose a random index to serialize
	 * @param min
	 * @param max
	 * @return random number between min and max
	 */
	public static int randStateData(int min, int max) {

		Random randNum = new Random();
		return randNum.nextInt((max - min) + 1) + min;
	}


}

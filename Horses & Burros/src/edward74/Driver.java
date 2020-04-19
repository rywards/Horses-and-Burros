package edward74;

import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import java.io.BufferedReader;
import java.io.File;
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
 * @version 4.15.2020
 */
public class Driver {

	public static void main(String[] args) throws IOException, StatisticDataNotFoundException {
		
		// Setting up classes 
		DataSet animalInfo = new DataSet();
		String stateData = "herdManage.csv";
		Reader herdManagement = new FileReader(stateData);
		
		try (Scanner file = new Scanner(new File(stateData))){
			if (file.hasNextLine()) {
				return;
			}
		} catch (StatisticDataNotFoundException s) {
			if (stateData.isEmpty())
				throw new StatisticDataNotFoundException(stateData, s);
			LocalDate.now();
		}
		
		loadStatistics(animalInfo, herdManagement, 7);
		animalInfo.displayStatistics(animalInfo.getStats());
		serialize(animalInfo.getStats().get(8));
		deserialize(animalInfo.getStats());
		
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
		          System.out.printf("Serialized data is saved in /(yourJavaProject)/HerdManagement.ser\n");
					         
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
	

}

package edward74;

import java.time.LocalDate;

/**
 * Exception catches if the statistic file is not found
 * @author Ryan edwards
 */
public class StatisticDataNotFoundException extends RuntimeException{

	private String key;
	
	public StatisticDataNotFoundException(String key) {
	
		this.key = key;
		toString();
	}
	
	public String getKey() {
		return key;
	}
	public String toString() {
		return ("\nFilename: " + key + "\n" + "Date: " + LocalDate.now() + "\n");
	}

}

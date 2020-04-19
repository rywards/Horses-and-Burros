package edward74;

import java.time.LocalDate;

/**
 * Exception catches if the statistic file is not found
 */
public class StatisticDataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -1535363645607776446L;
	
	public StatisticDataNotFoundException(String message, Throwable error) {
		super(message, error);
	}

}

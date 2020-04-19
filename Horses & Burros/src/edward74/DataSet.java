package edward74;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A dataset is a collection of statistics
 */
public class DataSet implements Serializable {
	
	/** the collection of statistics **/
	private ArrayList<Statistic> stats = new ArrayList<Statistic>(20);

	/**
	 * the full-argument constructor
	 * @param stats the ArrayList of Statistics
	 */
	public DataSet(ArrayList<Statistic> stats) {
		this.stats = stats;
	}
		
	/**
	 * the no-argument constructor which initializes the stats collection
	 */
	public DataSet() {
		this.stats = new ArrayList<Statistic>();
	}

	/**
	 * addStatistic will add a stat to the stats collection
	 * @param stat the statistic to add
	 */
	public void addStatistic(Statistic stat) {
		this.stats.add(stat);
	}

	/**
	 * standard accessor method
	 * @return the stats
	 */
	public ArrayList<Statistic> getStats() {
		return stats;
	}

	/**
	 * standard mutator method
	 * @param stats the stats to set
	 */
	public void setStats(ArrayList<Statistic> stats) {
		this.stats = stats;
	}
	
	/**
	 * Displays each row of statistics for each state
	 * @param stats
	 * @author Ryan Edwards
	 */
	public void displayStatistics (ArrayList<Statistic> stats) {
		 
		for (Statistic stat : stats) {
			StateStatistic stateStats = (StateStatistic) stat;
			System.out.println(stateStats.getState() + ", " + stateStats.getHerdAreaAcresBLM() + 
													   ", " + stateStats.getHerdAreaAcresOther() +
											           ", " + stateStats.getHerdManagementAreaAcresBLM() + 
											           ", " + stateStats.getHerdManagementAreaAcresOther() + 
											           ", " + stateStats.getNumHorses() + 
											           ", " + stateStats.getNumBurros());
			
			
		}
		
	}
	
	
	
}

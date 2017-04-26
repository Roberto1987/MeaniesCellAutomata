package util;
/**
 *
 * @author rob
 *
 * This class contains global public variables and global constants
 *
 */

public class Constants {
	/**
	 * Grid size
	 */
	 public static final int GRID_SIZE = 41;
	 public static final int TFT = 0;
	 public static final int ALLD = 1;
	 /**
	  * Time of delay to visualize the evolution of the system
	  */
	 public static final long DELAY = 1;
	 public static final int MAX_ITERATION=150;
	 /**
	  * Parameter set 1: true
	  * Parameter set 2: false
	  */
	 public static boolean pSet = false;
	 public static long stochasticChoice=0;
	 /**
	  * Array taking the number of meanies at each generation
	  */
	 public static int[] meanis;

	 /**
	  * Array taking the number of "not-meanies" at each generation
	  */
	 public static int[] notMeanis;

}

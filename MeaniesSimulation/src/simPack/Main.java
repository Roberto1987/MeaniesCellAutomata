package simPack;

import java.util.concurrent.TimeUnit;

import util.Constants;
import core.Environment;
import draw.DrawGraph;
/**
 * 
 * @author rob
 *
 */
public class Main {

	public static void main(String[] args) {
		Environment space = new Environment();
		space.setInvadingElement(); //Set the central cell with ALL D strategy
		//initialize statistical arrays
		Constants.meanis = new int[util.Constants.MAX_ITERATION+1];
		Constants.notMeanis = new int[util.Constants.MAX_ITERATION+1];
		while(space.getGeneration()<=util.Constants.MAX_ITERATION){
			space.Update();
			pause();
			
		}
		//System.out.println("Number of stochastic strategy choices was "+util.Constants.stochasticChoice);
		//graphing the meanis invasion
		System.out.println("The final number of meanis is:"+Constants.meanis[Constants.MAX_ITERATION]);
		//with false DrawGraph print the line graph about the number of meanis
		DrawGraph.createAndShowGui(false);
		
		
	}
	
	/**
	 * Delay method
	 */
	public static void pause(){
				try {
						TimeUnit.MILLISECONDS.sleep(util.Constants.DELAY);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}

}



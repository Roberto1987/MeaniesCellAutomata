package core;

import util.Constants;
/**
 * 
 * @author rob
 *
 */
public class Individual {
	private int row;
	private int column;
	private int strategy;
	private int strategyChoosed;
	private boolean change;
	private double score;
	
	private Coords eastNeigh;
	private Coords westNeigh;
	private Coords northNeigh;
	private Coords southNeigh;
	private int gSize=util.Constants.GRID_SIZE-1;
	
	/**
	 * 
	 * The neighbours are, in order, N,S,W,E;
	 *
	 * @param row
	 * @param column
	 * @param strategy
	 */
	public Individual(int row, int column, int strategy) {
		this.row = row;
		this.column = column;
		this.strategy = strategy;
		//Neighbours assignment are in mod gSize
		eastNeigh = new Coords(row,(gSize+column-1)%gSize);
		westNeigh = new Coords(row,(column+1)%gSize);
		southNeigh = new Coords((row+1)%gSize,column);
		northNeigh = new Coords((gSize+row-1)%gSize,column);
	
		/**
		 * I did a workaround on modulus operation with negative number: 
		 * when i subtract one for east and north newighbours, i used the rule 
		 * k-l = sizeOfTheGrid + k - l modulus sizeOfTheGrid
		 */
	}
	
	public void ChooseStrategy(){
		change=false;
		double max=0;
		double nScore=Environment.grid[northNeigh.getRow()][northNeigh.getColumn()].getScore();
		double sScore=Environment.grid[southNeigh.getRow()][southNeigh.getColumn()].getScore();
		double eScore=Environment.grid[eastNeigh.getRow()][eastNeigh.getColumn()].getScore();
		double wScore = Environment.grid[westNeigh.getRow()][westNeigh.getColumn()].getScore();
		max = Math.max(Math.max(nScore,sScore),Math.max(eScore  ,wScore ));
       	
		if(max>score)
		{
			
			if(nScore==max)
			{
				if(change==false)
				{
					strategyChoosed=Environment.grid[northNeigh.getRow()][northNeigh.getColumn()].getStrategy();
					change=true;
				}
				else
				{
					//if(Environment.grid[northNeigh.getRow()][northNeigh.getColumn()].getStrategy()!=strategyChoosed){
						//random pick
						if(Math.random()>=0.5){
							util.Constants.stochasticChoice++;
							strategyChoosed = Environment.grid[northNeigh.getRow()][northNeigh.getColumn()].getStrategy();
							
						}
						else
						{
							util.Constants.stochasticChoice++;
						}
					//}
						//else vuoto, la scelta c'è già (dal primo if) ed è identica a quella attuale
				}
				
			}
			//It pick ups a random strategy in ties situation also with same individuals strategy
			if(sScore==max)
			{
				if(change==false)
				{
					strategyChoosed=Environment.grid[southNeigh.getRow()][southNeigh.getColumn()].getStrategy();
					change=true;
				}
				else
				{
					//if(Environment.grid[southNeigh.getRow()][southNeigh.getColumn()].getStrategy()!=strategyChoosed){
						//random pick
						if(Math.random()>=0.5){
							util.Constants.stochasticChoice++;
							strategyChoosed = Environment.grid[southNeigh.getRow()][southNeigh.getColumn()].getStrategy();
						}
						else
						{
							util.Constants.stochasticChoice++;
						}
				//	}
				
				}
				
			}
			
			if(eScore==max)
			{
				if(change==false)
				{
					strategyChoosed=Environment.grid[eastNeigh.getRow()][eastNeigh.getColumn()].getStrategy();
					change=true;
				}
				else
				{
					//if(Environment.grid[eastNeigh.getRow()][eastNeigh.getColumn()].getStrategy()!=strategyChoosed){
						//random pick
						if(Math.random()>=0.5){
							util.Constants.stochasticChoice++;
							strategyChoosed = Environment.grid[eastNeigh.getRow()][eastNeigh.getColumn()].getStrategy();
						}
						else
						{
							util.Constants.stochasticChoice++;
						}
					//}
						
				}
				
			}
			
			if(wScore==max)
			{
				if(change==false)
				{
					strategyChoosed=Environment.grid[westNeigh.getRow()][westNeigh.getColumn()].getStrategy();
					change=true;
				}
				else
				{
					//if(Environment.grid[westNeigh.getRow()][westNeigh.getColumn()].getStrategy()!=strategyChoosed){
						//random pick
						if(Math.random()>=0.5){
							util.Constants.stochasticChoice++;
							strategyChoosed = Environment.grid[westNeigh.getRow()][westNeigh.getColumn()].getStrategy();
						}
						else
						{
						util.Constants.stochasticChoice++;
						}
					//}
				
				}
				
			}
			
		}
		
	}
	
	public void updateStrategy(){
		if(change){
			strategy = strategyChoosed;
			//updating the register for graph
			
					}
		if (strategy==1){
			util.Constants.meanis[Environment.generation]++;
		}
		if (strategy==0)
			{
			Constants.notMeanis[Environment.generation]++;
			}
			
		
	}
	
	public void computeScore(){
		
	  int NeighbourSum = neighbourSum();
	  if (strategy==0)
	  {
		  score = selectScoreTFT(NeighbourSum);
	  }
	  else
	  {
		  score = selectScoreALLD(NeighbourSum);
	  }
	  
	}
	
	/**
	 * 
	 * @return
	 * Calculating the sum of the strategies, we know how many ALLD strategies surrounding the cell  
	 * 
	 */
		private int neighbourSum(){
		int j=0;
		j =Environment.grid[northNeigh.getRow()][northNeigh.getColumn()].getStrategy() + 
				  Environment.grid[southNeigh.getRow()][southNeigh.getColumn()].getStrategy()+
				  Environment.grid[eastNeigh.getRow()][eastNeigh.getColumn()].getStrategy() +
				  Environment.grid[westNeigh.getRow()][westNeigh.getColumn()].getStrategy();
		return j;
	}
		
		/**
		 * Score calculation for a TFT individual
		 * @param nSum
		 * @return
		 */
		private double selectScoreTFT(int nSum){
			double avg=0;
			
			if(util.Constants.pSet){
					switch(nSum){
								case 0: avg = 43.5;
										break;
								case 1:  avg = 33.375;
								        break;
								case 2:  avg = 23.25;
								        break;
								case 3:  avg = 14.125;
								        break;
								case 4:  avg = 3;
								        break;
								default: System.out.println("Strange Neighourhood value, it is "+nSum+" exit");
								System.exit(0);
					}
				}
			else
			{
				switch(nSum){
					case 0: avg = 45;
							break;
					case 1:  avg = 35;
					        break;
					case 2:  avg = 25;
					        break;
					case 3:  avg = 15;
					        break;
					case 4:  avg = 5;
					        break;
					default: System.out.println("Strange Neighourhood value, it is "+nSum+" exit");
					System.exit(0);
				}
			}
			return avg;
			
		}
	
		/**
		 * Score calculation for a ALLD individual
		 * @param nSum
		 * @return
		 */
		
		private double selectScoreALLD(int nSum){
			double avg=0;
			//note that for each parameter, the score averages are the same
			if(util.Constants.pSet){
					switch(nSum){
								case 4: avg = 9;
										break;
								case 3:  avg = 21.5;
								        break;
								case 2:  avg = 34;
								        break;
								case 1:  avg = 46.5;
								        break;
								case 0:  avg = 59;
								        break;
								default: System.out.println("Strange Neighourhood value, it is "+nSum+" exit");
								System.exit(0);
					}
				}
			else
			{
				switch(nSum){
				case 4: avg = 9;
						break;
				case 3:  avg = 21.5;
				        break;
				case 2:  avg = 34;
				        break;
				case 1:  avg = 46.5;
				        break;
				case 0:  avg = 59;
				        break;
					default: System.out.println("Strange Neighourhood value, it is "+nSum+" exit");
					System.exit(0);
				}
			}
			return avg;
						
		}
	
   /**
    * 
    * @return
    */
	
	public double getScore() {
		return score;
	}


   /**
    * 
    * @return
    */
	public int getRow() {
		return row;
	}

	/**
	 * 
	 * @return
	 */
	public int getColumn() {
		return column;
	}
 
	/**
	 * 
	 * @return
	 */
	public int getStrategy() {
		return strategy;
	}

	/**
	 * 
	 * @param strategy
	 */
	public void setStrategy(int strategy) {
		this.strategy = strategy;
	}

	/**
	 * 
	 * @return
	 */
	public Coords getEastNeigh() {
		return eastNeigh;
	}

	/**
	 * 
	 * @return
	 */
	public Coords getWestNeigh() {
		return westNeigh;
	}

	/**
	 * 
	 * @return
	 */
	public Coords getNorthNeigh() {
		return northNeigh;
	}

	/**
	 * 
	 * @return
	 */
	public Coords getSouthNeigh() {
		return southNeigh;
	}

}

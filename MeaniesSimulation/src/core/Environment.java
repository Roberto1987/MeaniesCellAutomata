package core;

/**
 * 
 * @author rob
 *
 **/
public class Environment {

	/**
	 * I make Individual[][] grid public for sake of clearity of the code
	 */
	public static Individual[][] grid;
    private static int gSize= util.Constants.GRID_SIZE;
    public static int generation=1;
	
    /**
     * All strategies are setted as TFT as default
     * @param gSize
     */
    public Environment() {
		grid = new Individual[gSize][gSize];
		/**
		 * All strategies are setted as TFT 
		 */
		for(int i=0;i<gSize;i++){
			for(int j=0;j<gSize;j++){
				grid[i][j] = new Individual(i,j,util.Constants.TFT);
				
			}
		}
		generation = 1;
		
		
		
	}
    /**
     * This method set the central cell's individual strategy to TFT
     */
    public void setInvadingElement(){
    	grid[20][20].setStrategy(util.Constants.ALLD);
    }
    /**
     * This method update all individual's score
     */
    private void scoresUpdate(){
    	for(int i=0;i<gSize;i++){
			for(int j=0;j<gSize;j++){
				grid[i][j].computeScore();
			}
		}
    }
    /**
     * This method let choose the strategies for all cell:
     */
    private void strategiesChoose(){
    	for(int i=0;i<gSize;i++){
			for(int j=0;j<gSize;j++){
				grid[i][j].ChooseStrategy();
			}
		}
    }
    /**
     * This method implement a sinchronous update, based upon a previus strategiesChoose() running
     */
    private void strategiesUpdate(){
    	for(int i=0;i<gSize;i++){
			for(int j=0;j<gSize;j++){
				grid[i][j].updateStrategy();
			}
		}
    }

  
    
    
    public void Update(){
    	System.out.println("\n GENERATION: "+ generation);
    	printGrid();
       	scoresUpdate();
    	strategiesChoose();
    	strategiesUpdate();
    	generation++;
    
    }
	
    public int getGeneration(){
    	return generation;
    }
    /**
     * This method print the grid
     * 
     * In this method i used the unicode function: i note that in windows ambient some times it not accepts come unicode 
     * characters like black square and white square, so in this program i substitute the unicode characters with a blank space 
     * and the "at" @: while on the homework's image i left the unicode characters; here they are in the comments.
     */
    public void printGrid(){
    	for(int i=0;i<gSize;i++){
    		System.out.print("\n");	
			for(int j=0;j<gSize;j++){
				if(grid[i][j].getStrategy()==0){
					//System.out.print("|\u25A1|");
					System.out.print("| |");
				}
				else
				{
					//System.out.print("|\u25A0|");
					System.out.print("|@|");
				}
			
			}
			
		}
    }
    
}

package core;
/**
 * 
 * @author rob
 *
 * This class implements the coordinates 
 */
public class Coords {
	int row;
	int column;
	
/**
 * 
 * @param row
 * @param column
 */
	public Coords(int row, int column) {
		super();
		this.row = row;
		this.column = column;
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
 * @param row
 */
	public void setRow(int row) {
		this.row = row;
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
 * @param column
 */

	public void setColumn(int column) {
		this.column = column;
	}
	

	public void print(){
		System.out.println(row+","+column);
	}
}

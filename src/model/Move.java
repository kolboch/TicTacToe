package model;

public class Move {
	private int column;
	private int row;
	
	public Move(int column, int row){
		this.column = column;
		this.row = row;
	}
	
	public int getMoveRow(){
		return row;
	}
	
	public int getMoveColumn(){
		return column;
	}
	
	public void setRowAndColumn(int row, int column){
		this.row = row;
		this.column = column;
	}
}

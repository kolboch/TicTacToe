package controler;

import model.Board;
import model.FieldState;

public class Controller {
	
	private FieldState currentMove;
	private Board board;
	
	public Controller(){
		board = new Board();
	}
	
	public void setStartingSign(FieldState sign){
		currentMove = sign;
	}
	
	public FieldState getCurrentMoveSign(){
		return currentMove;
	}
	
	public void moveDone(){
		if(currentMove == FieldState.CIRCLE){
			currentMove = FieldState.CROSS;
		}
		else{
			currentMove = FieldState.CIRCLE;
		}
	}
	
	public void checkForWinner(){
		
	}
	
	public FieldState getBoardFieldState(int rowIndex, int columnIndex){
		return board.getFieldState(rowIndex, columnIndex);
	}
}

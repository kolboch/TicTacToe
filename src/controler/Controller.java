package controler;

import model.Board;
import model.FieldState;

public class Controller {
	
	private FieldState userSign;
	private FieldState currentMove;
	private Board board;
	private int movesDone;
	
	public Controller(){
		board = new Board();
		movesDone = 0;
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
		movesDone++;
	}
	
	public boolean hasGameWinner(){
		return board.checkForWinner();
	}
	
	public FieldState getBoardFieldState(int rowIndex, int columnIndex){
		return board.getFieldState(rowIndex, columnIndex);
	}
	
	public void resetGameStatus(){
		movesDone = 0;
		board.resetBoard();
	}
	
	public int getMovesDone(){
		return movesDone;
	}
	
	public FieldState getUserSign(){
		return userSign;
	}
	
	public void setUserSign(FieldState users){
		userSign = users;
	}
}

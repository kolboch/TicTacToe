package model;

public class Board {
	
	FieldState [][] board;
	
	public Board(){
		board = new FieldState[3][3];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = FieldState.EMPTY;
			}
		}
	}
	
	public FieldState getFieldState(int rowIndex, int columnIndex){
		return board[rowIndex][columnIndex];
	}
	
	public void setFieldState(int rowIndex, int columnIndex, FieldState state){
		board[rowIndex][columnIndex] = state;
	}
	
	public void resetBoard(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = FieldState.EMPTY;
			}
		}
	}
	
	public boolean checkForWinner(){
		FieldState firstState = null;
		boolean hasWinner = true;
		//checking rows
		for(int i = 0; i < board.length; i++){
			firstState = board[i][0];
			hasWinner = true;
			for(int j = 1; j < board[i].length && hasWinner; j++){
				if(board[i][j] != firstState){
					hasWinner = false;
				}
			}
		}
		if(hasWinner && firstState != FieldState.EMPTY){
			return hasWinner;
		} else{ hasWinner = true;}
		
		//checking columns
		for(int j = 0; j < board[0].length; j++){
			firstState = board[0][j];
			hasWinner = true;
			for(int i = 1; i < board.length && hasWinner; i++){
				if(board[i][j] != firstState){
					hasWinner = false;
				}
			}
		}
		if(hasWinner && firstState != FieldState.EMPTY){
			return hasWinner;
		} else{ hasWinner = true;}
		
		// checking diagonals
		firstState = board[0][0];
		for(int i = 1; i < board.length && hasWinner; i++){
			if(board[i][i] != firstState){
				hasWinner = false;
			}
		}
		if(hasWinner && firstState != FieldState.EMPTY){
			return hasWinner;
		} else{ hasWinner = true;}
		
		firstState = board[2][0];
		for(int i = 1, j = 1; i > 0 && hasWinner; i--, j++){
			if(board[i][j] != firstState){
				hasWinner = false;
			}
		}
		
		if(hasWinner && firstState != FieldState.EMPTY){
			return hasWinner;
		}
		else{
			return false;
		}
	}
	
}

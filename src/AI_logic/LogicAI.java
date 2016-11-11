package AI_logic;

import model.Board;
import model.FieldState;
import model.Move;

public class LogicAI {
	
	public Move AIgenerateMove(Board b, int movesDone, FieldState userSign, FieldState current){
		Move bestMove = new Move(-1, -1);
		int bestValue = Integer.MIN_VALUE;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(b.getFieldState(i, j) == FieldState.EMPTY){
					b.setFieldState(i, j, current);
					int moveValue = miniMax(b, movesDone + 1, userSign, userSign);
					b.setFieldState(i, j, FieldState.EMPTY);
					if(moveValue > bestValue){
						bestValue = moveValue;
						bestMove.setRowAndColumn(i, j);
					}
				}
			}
		}
		return bestMove;
	}
	
	int miniMax(Board b, int movesDone, FieldState userSign, FieldState current){
		int score = getBoardScore(b, userSign, current);
		if(score == 10){
			return score + (9 - movesDone);
		}
		if(score == -10){
			return score + (movesDone - 9);
		}
		if(movesDone == 9){
			return 0;
		}
		
		if(current != userSign){ // finding best for AI so we wanna MAXIMUM
			int best = Integer.MIN_VALUE;
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(b.getFieldState(i, j) == FieldState.EMPTY){
						b.setFieldState(i, j, current);
						best = Math.max(best, miniMax(b, movesDone + 1, userSign, userSign));
						b.setFieldState(i, j, FieldState.EMPTY);
					}
				}
			}
			return best;
		}
		else{ // finding best for user so we wanna MINIMUM
			int best = Integer.MAX_VALUE;
			FieldState next;
			if(current == FieldState.CIRCLE){
				next = FieldState.CROSS;
			}
			else{
				next = FieldState.CIRCLE;
			}
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(b.getFieldState(i, j) == FieldState.EMPTY){
						b.setFieldState(i, j, current);
						best = Math.min(best, miniMax(b, movesDone + 1, userSign, next));
						b.setFieldState(i, j, FieldState.EMPTY);
					}
				}
			}
			return best;
		}
	}
	
	private int getBoardScore(Board b, FieldState userSign, FieldState current){
		if(b.checkForWinner() == true){
			return userSign == current ? 10 : -10; // +10 for AI win, -10 for user win
		}
		else{
			return 0;
		}
	}
}

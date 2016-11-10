package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controler.Controller;
import model.FieldState;
import viewListeners.BoardPanelListener;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ResultsPanel resultPanel;
	private BoardPanel boardPanel;
	private Controller controller;
	
	public MainFrame(String name){
		super(name);
		controller = new Controller();
		
		resultPanel = new ResultsPanel();
		boardPanel = new BoardPanel();
		
		boardPanel.setBoardPanelListener(new BoardPanelListener(){
			public void doMove(int row, int column) {
				if(controller.isEmpty(row, column)){
					controller.doMove(row, column);
					updateButtonState(row, column, controller.getCurrentMoveSign());
					if(controller.hasGameWinner()){
						showWinMessage(controller.getCurrentMoveSign());
						controller.resetGameStatus();
						boardPanel.resetBoard();
					}
					else{
						controller.moveDone();
					}
				}
				else{
				}
			}
		});
		
		setLayout(new BorderLayout());
		add(resultPanel, BorderLayout.SOUTH);
		add(boardPanel, BorderLayout.CENTER);
	}
	
	private void showWinMessage(FieldState state){
		String message;
		if(state == controller.getUserSign()){
			message = "You won!!!";
		}
		else{
			message = "AI beat your ass ;(";
			
		}
		JOptionPane.showMessageDialog(null, message, "The winner is...", JOptionPane.PLAIN_MESSAGE);
	}
	
	private void updateButtonState(int row, int column, FieldState state){
		boardPanel.updateButtonState(row, column, state);
	}
}

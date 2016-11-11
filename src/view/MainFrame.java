package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import AI_logic.LogicAI;
import controler.Controller;
import model.FieldState;
import model.Move;
import viewListeners.BoardPanelListener;
import viewListeners.SettingsPanelListener;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ResultsPanel resultPanel;
	private BoardPanel boardPanel;
	private SettingsPanel settingsPanel;
	private Controller controller;
	private LogicAI logicAI;
	
	public MainFrame(String name){
		super(name);
		controller = new Controller();
		logicAI = new LogicAI();
		
		resultPanel = new ResultsPanel();
		boardPanel = new BoardPanel();
		settingsPanel = new SettingsPanel();
		
		controller.initGame(settingsPanel.doesUserStarts(), settingsPanel.getUserSymbol());
		
		boardPanel.setBoardPanelListener(new BoardPanelListener(){
			public void doMove(int row, int column) {
				if(controller.isEmpty(row, column)){
					controller.doMove(row, column);
					updateButtonState(row, column, controller.getCurrentMoveSign());
					
					if(controller.hasGameWinner()){
						showWinMessage(controller.getCurrentMoveSign());
						if(controller.getCurrentMoveSign() == controller.getUserSign()){
							resultPanel.incrementUserWinsScore();
						}
						else{
							resultPanel.incrementAIWinsScore();
						}
						resetDataAndUpdate();
					}
					else if(controller.getMovesDone() == 8){
							showDrawMessage();
							resultPanel.incrementDrawsScore();
							resetDataAndUpdate();
					}
					else{
							controller.moveDone();
							Move AImove = logicAI.AIgenerateMove(controller.getBoard(), controller.getMovesDone(), controller.getUserSign(), controller.getCurrentMoveSign());
							AImoves(AImove);
					}
				}
				else{
				}
			}
		});
		
		settingsPanel.setSettingsListener(new SettingsPanelListener(){
			public void whoStartChanged(boolean userStarts) {
				if(controller.getMovesDone() == 0){
					controller.initGame(userStarts, settingsPanel.getUserSymbol());
					if(!userStarts){
						Move AImove = logicAI.AIgenerateMove(controller.getBoard(), controller.getMovesDone(), controller.getUserSign(), controller.getCurrentMoveSign());
						AImoves(AImove);
					}
				}
			}
			public void userSymbolChanged(FieldState users) {
				if(controller.getMovesDone() == 0){
					controller.initGame(settingsPanel.doesUserStarts(), users);
				}
			}
			
		});
		
		setLayout(new BorderLayout());
		add(resultPanel, BorderLayout.SOUTH);
		add(boardPanel, BorderLayout.CENTER);
		add(settingsPanel, BorderLayout.EAST);
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
	
	private void showDrawMessage(){
		JOptionPane.showMessageDialog(null, "Draw! Play again!", "Game ended", JOptionPane.PLAIN_MESSAGE);
	}
	
	private void updateButtonState(int row, int column, FieldState state){
		boardPanel.updateButtonState(row, column, state);
	}
	
	private void resetDataAndUpdate(){
		controller.resetGameStatus();
		boardPanel.resetBoard();
		boolean userStarts = settingsPanel.doesUserStarts();
		controller.initGame(userStarts, settingsPanel.getUserSymbol());
		if(!userStarts){
			Move AImove = logicAI.AIgenerateMove(controller.getBoard(), controller.getMovesDone(), controller.getUserSign(), controller.getCurrentMoveSign());
			AImoves(AImove);
		}
	}
	
	private void AImoves(Move m){
		int row = m.getMoveRow();
		int column = m.getMoveColumn();
		controller.doMove(row, column);
		updateButtonState(row, column, controller.getCurrentMoveSign());
		
		if(controller.hasGameWinner()){
			showWinMessage(controller.getCurrentMoveSign());
			if(controller.getCurrentMoveSign() == controller.getUserSign()){
				resultPanel.incrementUserWinsScore();
			}
			else{
				resultPanel.incrementAIWinsScore();
			}
			resetDataAndUpdate();
		}
		else if(controller.getMovesDone() == 8){
				showDrawMessage();
				resultPanel.incrementDrawsScore();
				resetDataAndUpdate();
		}
		else{
				controller.moveDone();
		}
	}
}

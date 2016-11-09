package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controler.Controller;
import model.FieldState;

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
		
		setLayout(new BorderLayout());
		add(resultPanel, BorderLayout.SOUTH);
		add(boardPanel, BorderLayout.CENTER);
	}
	
	public void showWinMessage(FieldState state){
		String message;
		if(state == controller.getUserSign()){
			message = "You won!!!";
		}
		else{
			message = "AI beat your ass ;(";
		}
		//TODO JOptionPane.showMessageDialog(null, message, "The winner is...", JOptionPane.OK_OPTION, ICON_OF_WINNER_SIGN);
	}
}

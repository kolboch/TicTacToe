package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel winsTitleAI;
	private JLabel winsTitleUser;
	private JLabel drawsTitle;
	private JLabel winsAIScore;
	private JLabel winsUserScore;
	private JLabel drawsScore;
	
	public ResultsPanel(){
		winsTitleAI = new JLabel("AI wins");
		winsTitleUser = new JLabel("User wins");
		drawsTitle = new JLabel("Draws");
		
		winsAIScore = new JLabel("0");
		winsUserScore = new JLabel("0");
		drawsScore = new JLabel("0");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Insets labels = new Insets(5,20,5,20);
		gbc.insets = labels;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(winsTitleUser, gbc);
		gbc.gridx = 1;
		add(winsTitleAI, gbc);
		gbc.gridx = 2;
		add(drawsTitle, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(winsUserScore, gbc);
		gbc.gridx = 1;
		add(winsAIScore, gbc);
		gbc.gridx = 2;
		add(drawsScore, gbc);
		
	}
	
	public void incrementUserWinsScore(){
		int newScore = Integer.parseInt(winsUserScore.getText()) + 1;
		String res = Integer.toString(newScore);
		winsUserScore.setText(res);
	}
	
	public void incrementAIWinsScore(){
		int newScore = Integer.parseInt(winsAIScore.getText()) + 1;
		String res = Integer.toString(newScore);
		winsAIScore.setText(res);
	}
	
	public void incrementDrawsScore(){
		int newScore = Integer.parseInt(drawsScore.getText()) + 1;
		String res = Integer.toString(newScore);
		drawsScore.setText(res);
	}
}

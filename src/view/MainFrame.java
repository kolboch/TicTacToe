package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ResultsPanel resultPanel;
	private BoardPanel boardPanel;
	
	public MainFrame(String name){
		super(name);
		
		resultPanel = new ResultsPanel();
		boardPanel = new BoardPanel();
		
		setLayout(new BorderLayout());
		add(resultPanel, BorderLayout.SOUTH);
		add(boardPanel, BorderLayout.CENTER);
	}
}

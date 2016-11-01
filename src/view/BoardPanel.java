package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import viewListeners.BoardPanelListener;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton[][] boardFields;
	private BoardPanelListener listener;
	
	public BoardPanel(){
		boardFields = new JButton[3][3];
		for(int i = 0; i < boardFields.length; i++){
			for(int j = 0; j < boardFields[i].length; j++){
				boardFields[i][j] = new JButton();
				boardFields[i][j].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(listener != null){
							listener.doMove();
						}
					}
				});
			}
		}
		
		setLayout(new GridLayout(3,3));
		for(int i = 0; i < boardFields.length; i++){
			for(int j = 0; j < boardFields[i].length; j++){
				add(boardFields[i][j]);
			}
		}
	}
	
	public void setBoardPanelListener(BoardPanelListener listener){
		this.listener = listener;
	}
}

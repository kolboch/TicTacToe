package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import viewListeners.BoardPanelListener;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton[][] boardFields;
	private BoardPanelListener listener;
	private ImageIcon emptyImage;
	private ImageIcon circleImage;
	private ImageIcon crossImage;
	
	public BoardPanel(){
		boardFields = new JButton[3][3];
		try{
			setImagesLocation();
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(null, "Error when loading images", "Image loading error", JOptionPane.OK_OPTION);
			e.printStackTrace();
		}
		for(int i = 0; i < boardFields.length; i++){
			for(int j = 0; j < boardFields[i].length; j++){
				boardFields[i][j] = new JButton(emptyImage);
				boardFields[i][j].setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 2));
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
	
	private void setImagesLocation() throws IOException{
		emptyImage = new ImageIcon("images/empty.png");
		circleImage = new ImageIcon("images/circle.png");
		crossImage = new ImageIcon("images/cross.png");
	}
}

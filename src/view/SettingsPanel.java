package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.FieldState;
import viewListeners.SettingsPanelListener;

public class SettingsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private ButtonGroup userSymbol;
	private JRadioButton circle;
	private JRadioButton cross;
	private JLabel symbolLabel;
	
	private ButtonGroup whoGoFirst;
	private JRadioButton user;
	private JRadioButton AI;
	private JLabel whosFirstLabel;
	
	private SettingsPanelListener listener;
	
	public SettingsPanel(){
		userSymbol = new ButtonGroup();
		circle = new JRadioButton("Circle");
		cross = new JRadioButton("Cross");
		userSymbol.add(circle);
		userSymbol.add(cross);
		circle.setSelected(true);
		
		cross.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(listener != null){
					listener.userSymbolChanged(FieldState.CROSS);
				}
			}
		});
		circle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(listener != null){
					listener.userSymbolChanged(FieldState.CIRCLE);
				}
			}
		});
		
		whoGoFirst = new ButtonGroup();
		user = new JRadioButton("User");
		AI = new JRadioButton("AI");
		whoGoFirst.add(user);
		whoGoFirst.add(AI);
		user.setSelected(true);
		
		user.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(listener != null){
					listener.whoStartChanged(true);
				}
			}
		});
		AI.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(listener != null){
					listener.whoStartChanged(false);
				}
			}
		});
		
		symbolLabel = new JLabel("Choose your symbol:");
		whosFirstLabel = new JLabel("Who starts the game?");
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		Insets basicInsets = new Insets(5,5,5,5);
		gbc.insets = basicInsets;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		add(symbolLabel, gbc);
		gbc.gridwidth = 1;
		gbc.gridy = 1;
		add(circle, gbc);
		gbc.gridx = 1;
		add(cross,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		add(whosFirstLabel, gbc);
		gbc.gridwidth = 1;
		gbc.gridy = 3;
		add(user, gbc);
		gbc.gridx = 1;
		add(AI, gbc);
	}
	
	public boolean doesUserStarts(){
		return user.isSelected();
	}
	
	public FieldState getUserSymbol(){
		if(circle.isSelected()){
			return FieldState.CIRCLE;
		}
		else{
			return FieldState.CROSS;
		}
	}
	
	public void setSettingsListener(SettingsPanelListener listener){
		this.listener = listener;
	}
}

package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AppDemo {
	public static void main(String[]args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MainFrame frame = new MainFrame("Tic Tac Toe");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setMinimumSize(new Dimension(400,400));
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation((int)(screenSize.getWidth() - frame.getWidth())/2, (int)(screenSize.getHeight() - frame.getHeight()) / 2);
				frame.setVisible(true);
			}
		});
	}
}

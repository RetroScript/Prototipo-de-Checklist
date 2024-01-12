import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

public class FrameTesting {

	
	
	public static void makeTheWindowAppear() {
		
		JFrame myFrame = new JFrame("just testing the top-level containers");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel myLabel = new JLabel();
		myLabel.setOpaque(true);
		myLabel.setBackground(Color.yellow);
		myLabel.setPreferredSize(new Dimension(300,300));
		
		JMenuBar myMenuBar = new JMenuBar();
		myMenuBar.setOpaque(true);
		myMenuBar.setBackground(Color.green);
		myMenuBar.setPreferredSize(new Dimension(300, 100));
		
		myFrame.setJMenuBar(myMenuBar);
		myFrame.getContentPane().add(myLabel);
		
		myFrame.pack();
		myFrame.setVisible(true);
		
	}
	
	public static void main(String [] args) {
		
		makeTheWindowAppear();
		
	}
	
}

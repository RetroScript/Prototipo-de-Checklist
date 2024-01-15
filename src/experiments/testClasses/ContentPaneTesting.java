package experiments.testClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContentPaneTesting {

	public static void main(String [] args) {
		
		InitFrameAndContents();
		
	}
	
	public static void InitFrameAndContents() {
		
		final int cWIDTH = 50;
		final int cHEIGHT = 50;
		
		JFrame frame = new JFrame("my frame!");
		frame.setPreferredSize(new Dimension(300,300));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.pink);
//		panel.setPreferredSize(new Dimension(40,40));
		
		JLabel label = new JLabel("my label");
		label.setOpaque(true);
		label.setBackground(Color.cyan);
		label.setPreferredSize(new Dimension(cWIDTH,cHEIGHT));
		
		JLabel label1 = new JLabel("my label 1");
		label1.setOpaque(true);
		label1.setBackground(Color.yellow);
		label1.setPreferredSize(new Dimension(cWIDTH,cHEIGHT));
		
		JLabel label2 = new JLabel("my label 2");
		label2.setOpaque(true);
		label2.setBackground(Color.magenta);
		label2.setPreferredSize(new Dimension(cWIDTH,cHEIGHT));
		
		JLabel label3 = new JLabel("my label 3");
		label3.setOpaque(true);
		label3.setBackground(Color.black);
		label3.setPreferredSize(new Dimension(cWIDTH,cHEIGHT));
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		frame.getContentPane().add(label3, BorderLayout.SOUTH);
		frame.getContentPane().add(label2, BorderLayout.NORTH);
		frame.getContentPane().add(label1, BorderLayout.WEST);
		frame.getContentPane().add(label, BorderLayout.EAST);
		
//		frame.getContentPane().add(label3);
//		frame.getContentPane().add(label2);
//		frame.getContentPane().add(label1);
//		frame.getContentPane().add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
}

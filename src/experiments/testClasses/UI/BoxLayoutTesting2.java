package experiments.testClasses.UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BoxLayoutTesting2 {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane()
			.setPreferredSize(new Dimension(250,250));
		frame.getContentPane()
			.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.LINE_AXIS));
		
		JLabel l1 = new JLabel("Hello World");
		l1.setOpaque(true);
		l1.setBackground(Color.pink);
		l1.setForeground(Color.blue);
		l1.setAlignmentY(Box.TOP_ALIGNMENT);
		
		JLabel l2 = new JLabel("Hello World");
		l2.setOpaque(true);
		l2.setBackground(Color.red);
		l2.setForeground(Color.cyan);
		l2.setAlignmentY(Box.BOTTOM_ALIGNMENT);
		
		JLabel l3 = new JLabel("Hello World");
		l3.setOpaque(true);
		l3.setBackground(Color.magenta);
		l3.setForeground(Color.green);
		l3.setAlignmentY(Box.CENTER_ALIGNMENT);
		
		frame.getContentPane().add(l1);
		frame.getContentPane()
			.add(Box.createRigidArea(new Dimension(5,5)));
		frame.getContentPane().add(l2);
		frame.getContentPane()
			.add(Box.createRigidArea(new Dimension(5,5)));
		frame.getContentPane().add(l3);
		
		
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
}

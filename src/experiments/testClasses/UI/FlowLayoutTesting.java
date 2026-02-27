package experiments.testClasses.UI;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlowLayoutTesting {
	
	public static void main(String[] args) {
		
		FlowLayout fl = new FlowLayout();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane()
			.setPreferredSize(new Dimension(250,250));
		frame.getContentPane().setLayout(fl);
		
		frame.getContentPane().add(new JLabel("oi mundo"));
		frame.getContentPane().add(new JLabel("oi mundo"));
		frame.getContentPane().add(new JLabel("oi mundo"));


		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
}

package experiments.testClasses.UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BoxLayoutTesting {

	public static void main(String[] args) {
		
		JPanel CTP = new JPanel();
		CTP.setBackground(Color.GRAY);
		CTP.setPreferredSize(new Dimension(300,300));
		CTP.setLayout(new BoxLayout(CTP, BoxLayout.PAGE_AXIS));
		
		JFrame FRM = new JFrame();
		FRM.setContentPane(CTP);
		FRM.setVisible(true);
		FRM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRM.pack();
		
		JLabel l1 = new JLabel("Hello World");
		l1.setAlignmentX(Box.CENTER_ALIGNMENT);
		l1.setOpaque(true);
		l1.setForeground(Color.pink);
		CTP.add(l1);
		
		JLabel l2 = new JLabel("Heeellooo Wooorld");
		l2.setAlignmentX(Box.CENTER_ALIGNMENT);
		l2.setOpaque(true);
		l2.setBackground(Color.BLUE);
		CTP.add(l2);
		
		JLabel l3 = new JLabel("Heeeeellooooo Wooooorld");
		l3.setAlignmentX(Box.CENTER_ALIGNMENT);
		l3.setOpaque(true);
		l3.setBackground(Color.CYAN);
		CTP.add(l3);
		
		FRM.pack();
		FRM.setLocationRelativeTo(null);
		FRM.setResizable(false);
	}
	
}

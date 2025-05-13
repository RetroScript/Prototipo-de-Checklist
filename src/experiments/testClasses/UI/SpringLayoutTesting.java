package experiments.testClasses.UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class SpringLayoutTesting {

	public static void main(String[] args) {
		
		SpringLayoutTesting sp = new SpringLayoutTesting();
		
	}
	
	public SpringLayoutTesting() {

		
		
		JFrame frame  = new JFrame("janela");
		
		
		SpringLayout sl = new SpringLayout();
		Container MyContentPane = frame.getContentPane();
		MyContentPane.setLayout(sl);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.red);
		panel.setPreferredSize(new Dimension(500,500));
		
		JCheckBox ckb = new JCheckBox();
		ckb.setText("texto");
		
		sl.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, MyContentPane);
		sl.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, MyContentPane);
		
		
		sl.putConstraint(SpringLayout.SOUTH, MyContentPane, 5, SpringLayout.SOUTH, panel);
		sl.putConstraint(SpringLayout.EAST, MyContentPane, 5, SpringLayout.EAST, panel);
		
		
		MyContentPane.add(panel);
		MyContentPane.add(ckb);
		
		//To take the sizes of inner comps into the frame size
		frame.pack();
		frame.setResizable(true);
		frame.setVisible(true);
		
	}
	
}

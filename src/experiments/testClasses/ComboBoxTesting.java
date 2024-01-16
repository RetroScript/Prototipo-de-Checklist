package experiments.testClasses;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBoxTesting{

	public static void main(String [] args) {
		initFrameAndContents();
	}
	
	
	
	public static void initFrameAndContents() {
		
		ComboBoxTesting cbTest = new ComboBoxTesting();
		
		JFrame frame = new JFrame("ComboBoxTestinf");
		
		String comboBoxOptions[] = {"option1", "option2", "option3"};
		
		JComboBox<String> cb = new JComboBox<String>(comboBoxOptions);
		cb.setPreferredSize(new Dimension(100,50));
		cb.setSelectedIndex(2);
		
		frame.getContentPane().add(cb);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}

package experiments.testClasses;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardLayoutTesting2 extends JPanel implements ActionListener{

	public CardLayoutTesting2() {
		
		final String BUTTONPANEL = "panel 1 with button";
		final String LABELPANEL = "panel 2 with label";
		
		String comboBoxItems[] = {BUTTONPANEL, LABELPANEL};
		JComboBox cb = new JComboBox(comboBoxItems);
		cb.setEditable(false);
//		cb.addItemListener();
		
	}
	
	public static void initFrame() {
		JFrame frame = new JFrame("CardLayoutPaneTesting2");
		frame.setPreferredSize(new Dimension(300,300));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		initFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

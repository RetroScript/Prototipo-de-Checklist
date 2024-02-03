package experiments.testClasses;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutTesting implements ItemListener{

	public static void main(String [] args) {
		initFrameAndContents();
	}
	
	public static void initFrameAndContents() {
		
		JFrame frame = new JFrame("CardLayoutPanesTesting");
		frame.setPreferredSize(new Dimension(300,300));
		
		final String BUTTONPANEL = "panel 1 with button";
		final String LABELPANEL = "panel 2 with label";
		
		JPanel panel = new JPanel(new CardLayout());
		 
		JPanel card1 = new JPanel();
		card1.add(new JButton("card1"));
		JPanel card2 = new JPanel();
		card2.add(new JLabel("card2"));
		
		panel.add(card1, BUTTONPANEL);
		panel.add(card2, LABELPANEL);
		frame.getContentPane().add(panel);
	
		//Cria um gerenciador de layout, tendo como base o layout do panel.
		CardLayout CL = (CardLayout)(panel.getLayout());
		CL.show(panel, BUTTONPANEL);
//		CL.show(panel, LABELPANEL);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

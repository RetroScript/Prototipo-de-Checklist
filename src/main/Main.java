package main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JPanel implements ActionListener, ItemListener{
	
	public JPanel cardsP;
	public JPanel card0;
	public JPanel card1;
	public JPanel card2;
	public final int WIDTH = 600;
	public final int HEIGHT = 400;
	
	public final int tasksNumber = 3;
	public JTextField task1;
	public JTextField task2;
	public JTextField task3;
	
	public JButton criar;
	public JButton concluir;
	
	public Main() {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		

	}

	public void addTextFields(int width, int height, Color col, Container panel) {
		
		JTextField textField = new JTextField( );
		textField.setMaximumSize(new Dimension(width, height));
		textField.setBackground(col);
		textField.addActionListener(this);
		
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(textField);
	}
	
	public void initFrame() {
		JFrame frame = new JFrame("CheckList Program!");
		
		JComponent customCP = new Main();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setContentPane(customCP);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String [] args) {
		Main m = new Main();
		m.initFrame();
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		CardLayout cl = (CardLayout)(cardsP.getLayout());
		cl.show(cardsP, (String) e.getItem());
		
	}

}

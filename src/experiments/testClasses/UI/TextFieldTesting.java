package experiments.testClasses.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldTesting implements ActionListener{

	public JTextField TF;
	
	public TextFieldTesting() {
		
		JFrame frame = new JFrame("TextFieldTesting");
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setBackground(Color.magenta);
		panel.setPreferredSize(new Dimension(300,300));
		
		TF = new JTextField(20);
		TF.setBackground(Color.pink);
		TF.addActionListener(this);
		
		panel.add(TF);
		frame.setContentPane(panel);
		
		frame.pack();
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		TextFieldTesting TFT = new TextFieldTesting();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == TF) {
			
			String text = TF.getText();
			
			System.out.println("print: " + text);
			
		}
		
	}
	
}

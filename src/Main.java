import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends Canvas{
	
	public static JPanel panel;
	
	public static JButton button;
	
	
	//JFrame é um container
	//JFrame is a container
	public static JFrame frame;
	
	public static void main(String [] args) {
		
		Main m = new Main();
		
		frame = new JFrame("Checklist!");
	
//		//o tamanho do componente Canva, herdado por essa classe, é definido
//		//the Canva size, inherited from this class, is set		
//		m.setPreferredSize(new Dimension(300,300));
//		
//		//componente Canva é addicionado ao Frame
		//this add the Canva component to the Frame
//		frame.add(m);
		
		frame.setSize(new Dimension(300,300));
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(true);
		
//		//Actually, even reading the docs, I need to know how it works
//		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		
		panel = new JPanel();
		panel.setSize(new Dimension(300, 300));
		
		
		button = new JButton();
		button.setVisible(true);
		
		button.setBounds(100, 100, 75, 50);
		button.setText("hehe");
		button.setFocusable(false);
		
//		//somehow this didn't work, maybe I should isolate this and test more
//		button.setLocation(0, 0);
//		button.setPreferredSize(new Dimension(50,50));
		
		button.setBackground(Color.decode("#FF0000"));
		
		frame.add(button);
		
	
	}
	

}

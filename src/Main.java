import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main implements ActionListener{
	
	public static JPanel panel;
	
//	public static JButton buttonS;
	
	public static JButton createB;
	public static JButton deleteB;
	public static JButton editB;
	
	
	//JFrame é um container
	//JFrame is a container
	public static JFrame frame;
	
	public static void main(String [] args) {
		
		Main m = new Main();
		
		frame = new JFrame("Checklist!");
	
//		
//		//the Canva size, inherited from this class, is set		
//		m.setPreferredSize(new Dimension(300,300));
//		
//		//this add the Canva component to the Frame
//		frame.add(m);
		
		frame.setSize(new Dimension(300,300));
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
//		//Actually, even reading the docs, I still
//		//need to know how it works
//		frame.pack();
		
		
		//TEST PANEL -> proceed to test later
		
//		panel = new JPanel();
//		panel.setSize(new Dimension(300, 300));
		
		
//		//TEST BUTTON
//		buttonS = new JButton();
//		buttonS.setVisible(true);
//		
//		buttonS.setBounds(100, 100, 100, 50);
//		buttonS.setText("hehe");
//		buttonS.setFocusable(false);
//		buttonS.addActionListener(m);
//		buttonS.setBackground(Color.decode("#FF0000"));
//		frame.add(buttonS);

		
//		//somehow this didn't work, maybe I should isolate this and test more
//		button.setLocation(0, 0);
//		button.setPreferredSize(new Dimension(50,50));
		
		//FUNCTIONAL BUTTON
		m.loadMainMenu();
		
	}
	
	public void loadMainMenu() {
		

		createB = new JButton();
		createB.setVisible(true);
		createB.setText("CREATE");
		createB.setBounds(0, 0, 100, 50);
		createB.addActionListener(this);
		frame.add(createB);
		
		deleteB = new JButton();
		deleteB.setVisible(true);
		deleteB.setText("DELETE");
		deleteB.setBounds(100, 0, 100, 50);
		deleteB.addActionListener(this);
		frame.add(deleteB);
	
		editB = new JButton();
		editB.setVisible(true);
		editB.setText("EDIT");
		editB.setBounds(200, 0, 100, 50);
		editB.addActionListener(this);
		frame.add(editB);
		
	}
	
	public void loadCreationMenu() {
		
		
		
		frame.remove(createB);
		frame.remove(deleteB);
		frame.remove(editB);
		
		System.out.println("loading creation menu");
		
	}

	@Override
	//if some action occurs this method is called
	public void actionPerformed(ActionEvent e) {
		
		//if the button is pressed

//		if(e.getSource() == buttonS)
//		{		
//			
//			//do something
//			System.out.println("testing, working");
//			
//			
//			
//		}
		
		if(e.getSource() == createB) {
			
			//start the checklist creation menu
			
			loadCreationMenu();
			
		}
		
	}
	
	
	

}

package experiments.testClasses;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContentPaneTesting3 {

	public void addComponentsToGUI(Container pane) {

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,300));
		
		pane.add(panel);
	}
	
	public void initGUI() {
		
		JFrame frame = new JFrame();
		
		addComponentsToGUI(frame.getContentPane());
			
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public ContentPaneTesting3() {
		
		
	}
	
	public static void main(String [] args) {
		ContentPaneTesting3 CPT3 = new ContentPaneTesting3();
		
		CPT3.initGUI();
	}
	
}

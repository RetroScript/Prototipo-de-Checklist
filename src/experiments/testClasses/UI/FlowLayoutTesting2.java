package experiments.testClasses.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlowLayoutTesting2 {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JPanel ctp = new JPanel();
		ctp.setOpaque(true);
		ctp.setBackground(Color.LIGHT_GRAY);
		ctp.setPreferredSize(new Dimension(250,250));
		
		BoxLayout bl = new BoxLayout(ctp, BoxLayout.PAGE_AXIS);
		ctp.setLayout(bl);
		frame.setContentPane(ctp);

		JPanel flr = new JPanel();
		FlowLayout fl1 = new FlowLayout(FlowLayout.RIGHT);
		flr.setLayout(fl1);
		flr.setBackground(Color.PINK);
		flr.add(new JLabel("oi mundo"));
		flr.add(new JLabel("oi mundo"));
		flr.add(new JLabel("oi mundo"));
		ctp.add(Box.createGlue());
		ctp.add(flr);
		
		JPanel flc = new JPanel();
		FlowLayout fl2 = new FlowLayout(FlowLayout.CENTER);
		flc.setLayout(fl2);
		flc.setBackground(Color.GREEN);
		flc.add(new JLabel("oi mundo"));
		flc.add(new JLabel("oi mundo"));
		flc.add(new JLabel("oi mundo"));
		ctp.add(Box.createGlue());
		ctp.add(flc);
		
		
		JPanel fll = new JPanel();
		FlowLayout fl3 = new FlowLayout(FlowLayout.LEFT);
		fll.setLayout(fl3);
		fll.setBackground(Color.CYAN);
		fll.add(new JLabel("oi mundo"));
		fll.add(new JLabel("oi mundo"));
		fll.add(new JLabel("oi mundo"));
		ctp.add(Box.createGlue());
		ctp.add(fll);
		ctp.add(Box.createGlue());
		
		


		frame.pack();
		frame.setLocationRelativeTo(null);
		
	}
	
}

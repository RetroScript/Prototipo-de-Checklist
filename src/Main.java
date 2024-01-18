
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel implements ActionListener, ItemListener{
	
	public JPanel cardsP;
	public final int WIDTH = 500;
	public final int HEIGHT = 350;
	
	public Main() {
		super(new BorderLayout());
		
		JPanel cbPanel = new JPanel();
		cbPanel.setPreferredSize(new Dimension(0,150));
		cbPanel.setBackground(Color.lightGray);
		
		String cbOptions[] = {"CARD1", "CARD2"};
		JComboBox cb = new JComboBox(cbOptions);
		cb.setPreferredSize(new Dimension(300,100));
		cb.addItemListener(this);
		cbPanel.add(cb);
		
		cardsP = new JPanel(new CardLayout());
		cardsP.setBackground(Color.pink);
		cardsP.setPreferredSize(new Dimension(0, 200));
		
		JPanel card1 = new JPanel();
		card1.setBackground(Color.cyan);
		
		JPanel card2 = new JPanel();
		card2.setBackground(Color.magenta);
		
		
		cardsP.add(card1, cbOptions[0]);
		cardsP.add(card2, cbOptions[1]);
		
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(cbPanel, BorderLayout.NORTH);
		add(cardsP, BorderLayout.SOUTH);
		
		
	}
	
	public void initFrame() {
		JFrame frame = new JFrame("CheckList Program!");
		
		JComponent customCP = new Main();
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

		//Porque tem que ser chamado assim?
		CardLayout cl = (CardLayout)(cardsP.getLayout());
		cl.show(cardsP, (String) e.getItem());
		
	}

}

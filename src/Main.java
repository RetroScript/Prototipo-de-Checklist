
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
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
	public JPanel card1;
	public JPanel card2;
	public final int WIDTH = 500;
	public final int HEIGHT = 300;
	
	public JTextField nomeAtual;
	public JTextField nomeAnterior;
	
	public JTextField task1;
	public JTextField task2;
	public JTextField task3;
	
	public JButton criar;
	public JButton concluir;
	
	public Main() {
		super(new BorderLayout());
		
		JPanel cbPanel = new JPanel(/*new BorderLayout()*/);
		cbPanel.setLayout(new BoxLayout(cbPanel, BoxLayout.X_AXIS));
		cbPanel.setPreferredSize(new Dimension(0,100));
		cbPanel.setBackground(Color.lightGray);
		
		String cbOptions[] = {"CHECKLIST ATUAL", "CHECKLIST ANTERIOR"};
		JComboBox cb = new JComboBox(cbOptions);
		cb.setMaximumSize(new Dimension(300,50));
		cb.setAlignmentY(Component.CENTER_ALIGNMENT);
		cb.addItemListener(this);

		cbPanel.add(Box.createHorizontalGlue());
		cbPanel.add(cb);
		cbPanel.add(Box.createHorizontalGlue());
		
		cardsP = new JPanel(new CardLayout());
		cardsP.setBackground(Color.pink);
		cardsP.setPreferredSize(new Dimension(0, 200));
		
		//mostre a Checklist Atual e suas tasks
		//Caso não haja nenhuma ainda, sugira criar um checkList
		card1 = new JPanel();
		card1.setLayout(new BoxLayout(card1, BoxLayout.Y_AXIS));
		card1.setBackground(Color.cyan);
		
		JPanel card1Buttons= new JPanel();
		card1Buttons.setLayout(new BoxLayout(card1Buttons, BoxLayout.LINE_AXIS));
		card1Buttons.setBackground(Color.lightGray);
		
		
		
		criar = new JButton("Criar Nova checkList");
		criar.setFocusable(false);
		criar.addActionListener(this);
		concluir = new JButton("Concluir CheckList atual");
		concluir.setFocusable(false);
		concluir.addActionListener(this);
		
		nomeAtual = new JTextField(20);
		nomeAtual.setMaximumSize(new Dimension(450,100));
		nomeAtual.setBackground(Color.orange);
		nomeAtual.addActionListener(this);	
		
		task1 = new JTextField(20);
		task1.setMaximumSize(new Dimension(450,50));
		task2 = new JTextField(20);
		task2.setMaximumSize(new Dimension(450,50));
		task3 = new JTextField(20);
		task3.setMaximumSize(new Dimension(450,50));
		
		card1.add(Box.createRigidArea(new Dimension(0,5)));
		card1.add(nomeAtual);
		card1.add(Box.createRigidArea(new Dimension(0,5)));
		card1.add(task1);
		card1.add(Box.createRigidArea(new Dimension(0,5)));
		card1.add(task2);
		card1.add(Box.createRigidArea(new Dimension(0,5)));
		card1.add(task3);
		card1.add(Box.createRigidArea(new Dimension(0,5)));
		
		card1Buttons.add(Box.createHorizontalGlue());
		card1Buttons.add(criar);
		card1Buttons.add(Box.createRigidArea(new Dimension(25,0)));
		card1Buttons.add(concluir);
		card1Buttons.add(Box.createHorizontalGlue());
		
		
		card1.add(card1Buttons);
		
		
		//mostra todas as CheckLists já criadas
		card2 = new JPanel();
		card2.setBackground(Color.magenta);
		
		nomeAnterior = new JTextField(20);
		nomeAnterior.setBackground(Color.pink);
		nomeAnterior.addActionListener(this);
		card2.add(nomeAnterior);
		
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
		System.out.println(nomeAtual.getText());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		//Porque tem que ser chamado assim?
		CardLayout cl = (CardLayout)(cardsP.getLayout());
		cl.show(cardsP, (String) e.getItem());
		
	}

}

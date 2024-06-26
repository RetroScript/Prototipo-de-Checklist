package main;

import java.awt.BorderLayout;
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
	
	public JTextField nomeAtual;
	public JTextField nomeAnterior;
	
	public final int tasksNumber = 3;
	public JTextField task1;
	public JTextField task2;
	public JTextField task3;
	
	public JButton criar;
	public JButton concluir;
	
	public Main() {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.LINE_AXIS));
		selectionPanel.setPreferredSize(new Dimension(700,100));
		selectionPanel.setBackground(Color.BLUE);
		
		String cbOptions[] = {"CHECKLIST ATUAL", "CHECKLIST ANTERIOR"};
		JComboBox selector = new JComboBox(cbOptions);
		selector.setMaximumSize(new Dimension(300,50));
		selector.setAlignmentY(Component.CENTER_ALIGNMENT);
		selector.addItemListener(this);

		selectionPanel.add(Box.createRigidArea(new Dimension(50,0)));
		selectionPanel.add(selector);
		selectionPanel.add(Box.createRigidArea(new Dimension(50,0)));
		
		cardsP = new JPanel(new CardLayout());
		cardsP.setBackground(Color.pink);
		cardsP.setMaximumSize(new Dimension(WIDTH - 50, 250));
		
		//mostre a Checklist Atual e suas tasks
		//Caso não haja nenhuma ainda, sugira criar um checkList
		card1 = new JPanel();
		card1.setBackground(Color.cyan);
		
		card2 = new JPanel();
		card2.setBackground(Color.magenta);
		
		JPanel dataInput = new JPanel();
		dataInput.setLayout(new BoxLayout(dataInput, BoxLayout.PAGE_AXIS));
		dataInput.setPreferredSize(new Dimension(450,200));
		dataInput.setBackground(Color.red);
		
//		/////
		
		nomeAtual = new JTextField(20);
		task1 = new JTextField(20);
		task1.setMaximumSize(new Dimension(20,20));
		
		task2 = new JTextField(20);
		task2.setMaximumSize(new Dimension(20,20));
		
		task3 = new JTextField(20);
		task3.setMaximumSize(new Dimension(20,20));
		
		dataInput.add(nomeAtual);
		dataInput.add(task1);      
		dataInput.add(task2);      
		dataInput.add(task3);      
		
		JPanel card1Buttons = new JPanel();
		card1Buttons.setLayout(new BoxLayout(card1Buttons, BoxLayout.LINE_AXIS));
		card1Buttons.setMaximumSize(new Dimension(450, 100));
		card1Buttons.setBackground(Color.lightGray);
		
		criar = new JButton("Criar Nova checkList");
		criar.setFocusable(false);
		criar.addActionListener(this);
//		concluir = new JButton("Concluir CheckList atual");
//		concluir.setFocusable(false);
//		concluir.addActionListener(this);
		
		card1Buttons.add(Box.createHorizontalGlue());
		card1Buttons.add(criar);
//		card1Buttons.add(Box.createRigidArea(new Dimension(25,0)));
//		card1Buttons.add(concluir);
		card1Buttons.add(Box.createHorizontalGlue());
		
//		card1.add(Box.createRigidArea(new Dimension(0,7)));
		card1.add(dataInput);
//		card1.add(Box.createRigidArea(new Dimension(0,25)));
		card1.add(card1Buttons);
		
		cardsP.add(card1, cbOptions[0]);
		cardsP.add(card2, cbOptions[1]);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		add(Box.createRigidArea(new Dimension(0, 15)));
		add(selectionPanel);
		add(Box.createRigidArea(new Dimension(0, 15)));
		add(cardsP);
		add(Box.createRigidArea(new Dimension(0, 15)));
		
		

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
		
		JTextField nome = (JTextField)(card1.getComponent(1));
//		System.out.println(nome.getText());
		

		JTextField task1 = (JTextField)(card1.getComponent(3));
//		System.out.println(task1.getText());
		

		JTextField task2 = (JTextField)(card1.getComponent(5));
//		System.out.println(task2.getText());
		

		JTextField task3 = (JTextField)(card1.getComponent(7));
//		System.out.println(task3.getText());
		
		if(e.getSource() == criar) {
			
			Checklist list1 = new Checklist(nome.getText(), task1.getText(), task2.getText(), task3.getText());
			
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		//Porque tem que ser chamado assim?
			//o Layout Manager retornado precisa ser tipado
		CardLayout cl = (CardLayout)(cardsP.getLayout());
		cl.show(cardsP, (String) e.getItem());
		
	}

}

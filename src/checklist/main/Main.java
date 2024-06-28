package checklist.main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JPanel implements ItemListener, ActionListener{

	public JPanel menusPanel;
	public JPanel menu1Panel;
	public JPanel menu2Panel;
	public JPanel menu3Panel;

	public CardLayout CL;
	
	JLabel warningLabel;
	
	public JPanel selectorPanel;
	public JComboBox<String> menuSelector;
	public String menuOptions[] = {"CRIAR CHECKLIST", "CHECKLIST ATUAL", "CHECKLIST ANTERIOR"};
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public Main() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		selectorPanel = new JPanel();
		selectorPanel.setLayout(new BoxLayout(selectorPanel, BoxLayout.LINE_AXIS));
		selectorPanel.setBackground(Color.gray);
		selectorPanel.setMaximumSize(new Dimension(WIDTH - 50, (HEIGHT / 2) - 25));
		
		menuSelector = new JComboBox<String>(menuOptions);
		menuSelector.setMinimumSize(new Dimension(WIDTH /2, 100));
		menuSelector.setMaximumSize(new Dimension(WIDTH /2, 100));
//		menuSelector.setAlignmentX(CENTER_ALIGNMENT);
		menuSelector.addItemListener(this);
		
		menusPanel = new JPanel(new CardLayout());
		menusPanel.setBackground(Color.gray);
		menusPanel.setMaximumSize(new Dimension(WIDTH - 50, (HEIGHT / 2) - 25));
		
		
		
		menu1Panel = new JPanel();
		menu1Panel.setBackground(Color.red);
		
		JPanel tfPanel = new JPanel();
		tfPanel.setBackground(Color.CYAN);
		tfPanel.setPreferredSize(new Dimension(400, 150));
		
		addTextField("title", 50, 50, Color.white, tfPanel);
		addTextField("task 1", 50, 20, Color.white, tfPanel);
		addTextField("task 2", 50, 20, Color.white, tfPanel);
		addTextField("task", 50, 20, Color.white, tfPanel);
		menu1Panel.add(tfPanel);
		
		JButton createButton = new JButton("Criar");
		createButton.addActionListener(this);
		menu1Panel.add(createButton);
		
		
		menu2Panel = new JPanel();
		menu2Panel.setBackground(Color.blue);
		warningLabel = new JLabel();
		warningLabel.setText("Meio vazio? Crie uma checkList para começar!");
		warningLabel.setOpaque(true);
		warningLabel.setBackground(Color.magenta);
		menu2Panel.add(warningLabel);

		
		menu3Panel = new JPanel();
		menu3Panel.setBackground(Color.yellow);
		JLabel lastWarningLabel = new JLabel();
		lastWarningLabel.setText("Ainda não Concluiu? Termine uma checklist e veja ela nesse histórico");
		lastWarningLabel.setOpaque(true);
		lastWarningLabel.setBackground(Color.magenta);
		menu3Panel.add(lastWarningLabel);
		
		selectorPanel.add(Box.createGlue());
		selectorPanel.add(menuSelector);
		selectorPanel.add(Box.createGlue());
		
		menusPanel.add(menu1Panel, menuOptions[0]);
		menusPanel.add(menu2Panel, menuOptions[1]);
		menusPanel.add(menu3Panel, menuOptions[2]);
		
		CL = (CardLayout)(menusPanel.getLayout());
		
		add(Box.createRigidArea(new Dimension(0, 25)));
		add(selectorPanel);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(menusPanel);
		add(Box.createRigidArea(new Dimension(0,25)));
		
	}
	
	public void addTextField(String fieldTitle, int wid, int hei, Color col, Container pane) {
		JTextField tf = new JTextField(20);
		tf.setBackground(col);
		tf.setPreferredSize(new Dimension(wid, hei));
		tf.setToolTipText("set the " + fieldTitle + " here");
		pane.add(tf);
		
	}
	
	public void initSecondCard() {
		
		Container TFPanel = (Container) menu1Panel.getComponent(0);
		
		JTextField titleTF = (JTextField) TFPanel.getComponent(0);
		JTextField task1TF = (JTextField) TFPanel.getComponent(1);
		JTextField task2TF = (JTextField) TFPanel.getComponent(2);
		JTextField task3TF = (JTextField) TFPanel.getComponent(3);
		
		String title = titleTF.getText();
		String task1 = task1TF.getText();
		String task2 = task2TF.getText();
		String task3 = task3TF.getText();
		
		String[] listInfo = {title, task1, task2, task3};
		
		createChecklist(title, listInfo[1],listInfo[2],listInfo[3]);
		
		
	}
	
	public static void initGUI() {
		JFrame frame = new JFrame("checklist bro");
		frame.setResizable(true);
		frame.setLayout(new FlowLayout());
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		
		JComponent cp = new Main();
		frame.setContentPane(cp);
		
		
		frame.pack();
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		initGUI();
		System.out.println("hello world");
		
	}
	
	public void createChecklist(String listname, String task1name, String task2name, String task3name) {
		
		menu2Panel.removeAll();
		JComponent creationPanel = (JComponent) menu1Panel.getComponent(0);
		JTextField creationPanelTFTs;
		for(int i = 0; i < creationPanel.getComponentCount(); i++) {
		
			System.out.println("modifying mt text fields");
			
			creationPanelTFTs = (JTextField) creationPanel.getComponent(i);
			creationPanelTFTs.setText(null);
			
		}
		
		CheckList list = new CheckList(listname, task1name, task2name, task3name);
		System.out.println("checklist created");
		
		CL.show(menusPanel, menuOptions[1]);
		menuSelector.setSelectedIndex(1);
		
		JTextField tf = new JTextField(20);
		tf.setBackground(Color.white);
		tf.setPreferredSize(new Dimension(50, 50));
		tf.setText(listname);
		tf.setEditable(false);
		tf.setFocusable(false);
		
		JTextField task1 = new JTextField(20);
		task1.setBackground(Color.white);
		task1.setPreferredSize(new Dimension(50, 20));
		task1.setText(task1name);
		task1.setEditable(false);
		task1.setFocusable(false);
		
		JTextField task2 = new JTextField(20);
		task2.setBackground(Color.white);
		task2.setPreferredSize(new Dimension(50, 20));
		task2.setText(task2name);
		task2.setEditable(false);
		task2.setFocusable(false);
		
		JTextField task3 = new JTextField(20);
		task3.setBackground(Color.white);
		task3.setPreferredSize(new Dimension(50, 20));
		task3.setText(task3name);
		task3.setEditable(false);
		task3.setFocusable(false);
		
		menu2Panel.remove(warningLabel);
		menu2Panel.add(tf);
		menu2Panel.add(task1);
		menu2Panel.add(task2);
		menu2Panel.add(task3);
		
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		CL.show(menusPanel, (String)e.getItem());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		JButton createButton = (JButton) menu1Panel.getComponent(1);
		
		if(e.getSource() == createButton) {
			
			System.out.println("create button pressed");
			
			initSecondCard();
			
		}
		
	}
	
}

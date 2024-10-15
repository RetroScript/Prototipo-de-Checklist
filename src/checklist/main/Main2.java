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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main2 extends JPanel implements ItemListener, ActionListener{

	public JPanel menusPanel;
	public JPanel menu1Panel;
	public JPanel menu2Panel;
	public JPanel menu3Panel;

	public ArrayList<JTextField> menu1Contents = new ArrayList<JTextField>();
	public ArrayList<JTextField> menu2Contents = new ArrayList<JTextField>();
	
	public CardLayout CL;
	
	JLabel warningLabel;
	
	public JPanel selectorPanel;
	public JComboBox<String> menuSelector;
	public String menuOptions[] = {"CRIAR CHECKLIST", "CHECKLIST ATUAL", "CHECKLIST ANTERIOR"};
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public Main2() {
		
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
		
		addTextField("title", 50, 50, Color.white, menu1Contents);
		addTextField("task 1", 50, 20, Color.white, menu1Contents);
		addTextField("task 2", 50, 20, Color.white, menu1Contents);
		addTextField("task 3", 50, 20, Color.white, menu1Contents);
		
		for(int i = 0; i < menu1Contents.size(); i++) {
			
			tfPanel.add(menu1Contents.get(i));
			
		}
			
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
	
	public void addTextField(String fieldTitle, int wid, int hei, Color col, ArrayList<JTextField> TFGroup) {
		JTextField tf = new JTextField(20);
		tf.setBackground(col);
		tf.setPreferredSize(new Dimension(wid, hei));
		tf.setToolTipText("set the " + fieldTitle + " here");
		
		TFGroup.add(tf);
		
	}
	
	public void addFixedTextField(String fieldTitle, String fieldText, int wid, int hei, ArrayList<JTextField> TFGroup) {
		JTextField tf = new JTextField(20);
		tf.setBackground(Color.white);
		tf.setPreferredSize(new Dimension(wid, hei));
		tf.setText(fieldText);
		tf.setName(fieldTitle);
		tf.setEditable(false);
		tf.setFocusable(false);
		
		TFGroup.add(tf);
	}
	
	
	public static void initGUI() {
		JFrame frame = new JFrame("checklist bro");
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		
		JComponent cp = new Main2();
		frame.setContentPane(cp);
		
		
		frame.pack();
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
	}
	
	public void initSecondCard() {
		
	}
	
	public void createChecklist() {
		
		for(int i = 0; i < menu2Contents.size(); i++) {
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		Main2 main = new Main2();
		initGUI();
		System.out.println("hello world");
		
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
			
			createChecklist();
			
		}
		
	}
	
}

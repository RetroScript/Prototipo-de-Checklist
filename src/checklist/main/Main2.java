package checklist.main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main2 extends JPanel implements ItemListener, ActionListener{

	
	private static final long serialVersionUID = -8820286385818338364L;
	public JPanel menusPanel;
	public JPanel menu1Panel;
	public JPanel menu2Panel;
	public JPanel menu3Panel;

	public ArrayList<JTextField> menu1Contents = new ArrayList<JTextField>();
	public ArrayList<Component> menu2Contents = new ArrayList<Component>();
	public ArrayList<Component> menu3Contents = new ArrayList<Component>();
	
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
		

		try {
			CheckList cl = (CheckList) FileManager.load("checkList.save");
			
			if(cl != null) {
				
				initThirdCard();
				CL.show(menusPanel, menuOptions[2]);
				menuSelector.setSelectedIndex(2);
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	public void addTextField(String fieldTitle, int wid, int hei, Color col, ArrayList<JTextField> TFGroup) {
		JTextField tf = new JTextField(20);
		tf.setBackground(col);
		tf.setPreferredSize(new Dimension(wid, hei));
		tf.setToolTipText("set the " + fieldTitle + " here");
		
		TFGroup.add(tf);
		
	}
	
	public void addFixedTextField(String fieldTitle, String fieldText, int wid, int hei, ArrayList<Component> TFGroup) {
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
		
		JPanel contentsInfoPanel = new JPanel();
		contentsInfoPanel.setBackground(Color.black);
		contentsInfoPanel.setPreferredSize(new Dimension(400,150));
		contentsInfoPanel.setLayout(new BoxLayout(contentsInfoPanel, BoxLayout.PAGE_AXIS));
		
		JButton finishButton = new JButton("Concluir");
		finishButton.addActionListener(this);
		
		menu2Contents.removeAll(menu2Contents);
		contentsInfoPanel.removeAll();
		
		JCheckBox option1 = new JCheckBox("");
		JCheckBox option2 = new JCheckBox("");
		JCheckBox option3 = new JCheckBox("");
		
		
		
		try {
			CheckList cl = (CheckList)FileManager.load("checkList.save");
			
			addFixedTextField("CLTittle", cl.getName(), 50, 50, menu2Contents);
//			addFixedTextField("CLTask1", cl.getTasks(0), 50, 20, menu2Contents);
//			addFixedTextField("CLTask2", cl.getTasks(1), 50, 20, menu2Contents);
//			addFixedTextField("CLTask3", cl.getTasks(2), 50, 20, menu2Contents);
			option1.setText(cl.getTasks(0));
			option2.setText(cl.getTasks(1));
			option3.setText(cl.getTasks(2));
			
			menu2Contents.add(option1);
			menu2Contents.add(option2);
			menu2Contents.add(option3);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		menu2Panel.removeAll();
			
		contentsInfoPanel.add(Box.createRigidArea(new Dimension(0,20)));
		
		for(int i = 0; i < menu2Contents.size(); i++) {
			
			contentsInfoPanel.add(Box.createRigidArea(new Dimension(5,5)));
			contentsInfoPanel.add(Box.createHorizontalGlue());
			contentsInfoPanel.add(menu2Contents.get(i));
			contentsInfoPanel.add(Box.createHorizontalGlue());
			contentsInfoPanel.add(Box.createRigidArea(new Dimension(5,5)));
		}
		
		contentsInfoPanel.add(Box.createRigidArea(new Dimension(0,20)));
		contentsInfoPanel.setAlignmentX(Box.CENTER_ALIGNMENT);
		
//		menu2Contents.get(0).setMaximumSize(new Dimension(500,50));
		menu2Panel.add(contentsInfoPanel);
		menu2Panel.add(finishButton);
		
		CL.show(menusPanel, menuOptions[1]);
		menuSelector.setSelectedIndex(1);
		
	}
	
	public void initThirdCard() {	
		
		menu3Panel.removeAll();
		
//		menu3Contents.remove(0);
//		menu3Contents.remove(1);
//		menu3Contents.remove(2);
//		menu3Contents.remove(3);
//		
//		menu3Contents.clear();
		
		
		JLabel lastCLWarning = new JLabel("Esta foi a ultima CL que voce concluiu! Parabens!");
		lastCLWarning.setOpaque(true);
		lastCLWarning.setBackground(Color.pink);
		
		JLabel lastCLWarning2 = new JLabel("Que tal fazer outra CL?");
		lastCLWarning2.setOpaque(true);
		lastCLWarning2.setBackground(Color.pink);
		
		JButton newCL = new JButton("Fa�a outra CL! Clique >AQUI<!!!");
		
		JPanel contentsInfoPanel = new JPanel();
		contentsInfoPanel.setBackground(Color.magenta);
		contentsInfoPanel.setPreferredSize(new Dimension(400,150));
		
		
		menu3Contents.removeAll(menu3Contents);
		contentsInfoPanel.removeAll();
		
		try {
			CheckList cl = (CheckList) FileManager.load("checkList.save");
			
			addFixedTextField("CLTittle", cl.getName(), 50, 50, menu3Contents);
			addFixedTextField("CLTask1", cl.getTasks(0), 50, 20, menu3Contents);
			addFixedTextField("CLTask2", cl.getTasks(1), 50, 20, menu3Contents);
			addFixedTextField("CLTask3", cl.getTasks(2), 50, 20, menu3Contents);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < menu3Contents.size(); i++) {
			
			menu3Contents.get(i).setBackground(Color.pink);
			contentsInfoPanel.add(menu3Contents.get(i));
			
		}
		
		

		menu3Panel.add(lastCLWarning);
		menu3Panel.add(contentsInfoPanel);
		menu3Panel.add(lastCLWarning2);
		menu3Panel.add(newCL);
		
		newCL.addActionListener( e -> {
			
			CL.show(menusPanel, menuOptions[0]);
			menuSelector.setSelectedIndex(0);
			
			menu1Contents.get(0).setText(null);
			menu1Contents.get(1).setText(null);
			menu1Contents.get(2).setText(null);
			menu1Contents.get(3).setText(null);
//			menu3Panel.removeAll();
			
		});
		
		CL.show(menusPanel, menuOptions[2]);
		menuSelector.setSelectedIndex(2);
	}
	public void createChecklist() {
		
		String[] listInfo = new String[menu1Contents.size()];
		
		for(int i = 0; i < menu1Contents.size(); i++) {
			
			listInfo[i] = (String) menu1Contents.get(i).getText();
			
		}
		CheckList cl = new CheckList(listInfo[0], listInfo[1], listInfo[2], listInfo[3]);
		try {
			FileManager.save(cl, "checkList.save");
		} catch (Exception e) {
			System.out.println("couldn't save your checklist: " + e.getMessage());
		}
		
		initSecondCard();
		
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
		
		JButton finishButton = (JButton) menu2Panel.getComponent(1);
		
		if(e.getSource() == finishButton) {
			
			initThirdCard();
			
		}
		
	}
	
}

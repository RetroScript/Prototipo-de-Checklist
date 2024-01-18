package experiments.testClasses;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxTesting2 implements ActionListener{

	//O QUE É UM ComboBox?
		/*
		 * uma combobox é um componente do swing que exibe um menu com 
		 * diversas opções pré-programadas para o usuário escolher.
		 * 
		 * uma combobox pode adicionar um ActionListener para que quando 
		 * uma ação for realizada, como a escolha de uma das opções,
		 * algo aconteça.
		 * 
		 * uma ComboBox também pode ser usada em conjunto com CardLayout's,
		 * que alteram a exibição de determinados grupos de componentes a 
		 * partir do estado da ComboBox, o que é realizado com o uso de um
		 * ActionListener.
		 * 
		 * Essa classe não irá só criar uma ComboBox, mas usá-la para conferir
		 * seus estados e a partir destes mudar um dos componentes dentro 
		 * da JFrame.
		 * 
		 */
	
	public JComboBox cb;
	public String stringOptions[] = {"option1", "option2", "option3"};
	
	public static void main(String [] args) {
		
		createAndShowGUI();
		
	}
	
	public static void createAndShowGUI() {
		//Instancia a Classe para permitir acessa ao dados globais
		ComboBoxTesting2 cbTest2 = new ComboBoxTesting2();
		
		//Cria uma Janela
		JFrame frame = new JFrame("ComboBoxTesting");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//inicializa a ComboBox cb e configura suas opções,
		//seu tamanho também é definido e o ActionListener é adicionado
		cbTest2.cb = new JComboBox(cbTest2.stringOptions);
		cbTest2.cb.setPreferredSize(new Dimension(300,300));
		cbTest2.cb.addActionListener(cbTest2);
		
		//adiciona a ComboBox cb ao Content Pane
		frame.getContentPane().add(cbTest2.cb);		
		
		//Redimensiona e exibe a janela
		frame.pack();
		frame.setVisible(true);
	}

	//É chamado quando um ação acontece
	public void actionPerformed(ActionEvent e) {
		
		//verifica se a ultima ação é da ComboBox cb
		if(e.getSource() == cb) {
			
			//Verifica se o item selecionado confere alguma das opções
			//e realiza suas respectivas respostas
			if(cb.getSelectedItem() == stringOptions[0]) {
				
				System.out.println("option 1");
				
			}
			
			if(cb.getSelectedItem() == stringOptions[1]) {
				
				System.out.println("option 2");
				
			}
			
			if(cb.getSelectedItem() == stringOptions[2]) {
				
				System.out.println("option 3");
				
			}
			
		}
		
	}

}

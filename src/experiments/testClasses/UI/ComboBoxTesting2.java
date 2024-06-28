package experiments.testClasses.UI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxTesting2 implements ActionListener{

	//O QUE � UM ComboBox?
		/*
		 * uma combobox � um componente do swing que exibe um menu com 
		 * diversas op��es pr�-programadas para o usu�rio escolher.
		 * 
		 * uma combobox pode adicionar um ActionListener para que quando 
		 * uma a��o for realizada, como a escolha de uma das op��es,
		 * algo aconte�a.
		 * 
		 * uma ComboBox tamb�m pode ser usada em conjunto com CardLayout's,
		 * que alteram a exibi��o de determinados grupos de componentes a 
		 * partir do estado da ComboBox, o que � realizado com o uso de um
		 * ActionListener.
		 * 
		 * Essa classe n�o ir� s� criar uma ComboBox, mas us�-la para conferir
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
		
		//inicializa a ComboBox cb e configura suas op��es,
		//seu tamanho tamb�m � definido e o ActionListener � adicionado
		cbTest2.cb = new JComboBox(cbTest2.stringOptions);
		cbTest2.cb.setPreferredSize(new Dimension(300,300));
		cbTest2.cb.addActionListener(cbTest2);
		
		//adiciona a ComboBox cb ao Content Pane
		frame.getContentPane().add(cbTest2.cb);		
		
		//Redimensiona e exibe a janela
		frame.pack();
		frame.setVisible(true);
	}

	//� chamado quando um a��o acontece
	public void actionPerformed(ActionEvent e) {
		
		//verifica se a ultima a��o � da ComboBox cb
		if(e.getSource() == cb) {
			
			//Verifica se o item selecionado confere alguma das op��es
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

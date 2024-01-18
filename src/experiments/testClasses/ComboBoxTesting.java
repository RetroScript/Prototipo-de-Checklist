package experiments.testClasses;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBoxTesting{

	//O QUE É UMA ComboBox?
		/*
		 * uma combobox é um componente do swing que exibe um menu com 
		 * diversas opções pré-programadas para o usuário escolher.
		 *
		 * uma combobox pode adicionar um ActionListener para que quando 
		 * uma ação for realizada, como a escolha de uma das opções,
		 * algo aconteça. Isso será aprofundado mais tarde, com a elaboração
		 * de outros experimentos.
		 * 
		 * Essa Classe tem como objetivo mostrar, de modo superficial
		 * o funcionamento básico de uma ComboBox
		 */
	
	public static void main(String [] args) {
		initFrameAndContents();
	}
	
	public static void initFrameAndContents() {
		
		JFrame frame = new JFrame("ComboBoxTestinf");
		
		//Uma array com as opções que uma ComboBox pode ter
		String comboBoxOptions[] = {"option1", "option2", "option3"};
		
		//Cria uma ComboBox com o nome de cb e com as opções correspondentes
		//ao nomes da Array comboBoxOptions[].
		//Seu tamanho pode ser definido com o setPreferedSize();
		//O index pode ser definido com o setSelectedIndex();
		JComboBox<String> cb = new JComboBox<String>(comboBoxOptions);
		cb.setPreferredSize(new Dimension(300,300));
		cb.setSelectedIndex(2);
		
		//Adiciona a ComboBox ao Content Pane
		frame.getContentPane().add(cb);
		
		//configura, redimensiona, e mostra a JFrame frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
}
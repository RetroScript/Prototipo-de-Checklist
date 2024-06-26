package experiments.testClasses.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutTesting {

	//O QUE � UM BorderLayout?
		/*
		 *Um BorderLayout � um LayoutManager que disp�e os elementos nas 
		 *bordas de um container qualquer dividindo-o em quatro posi��es: 
		 *norte, sul, leste, oeste e centro-oeste.
		 * 
		 * Para se usar o BorderLayout deve-se passar uma de suas 
		 * propriedades, as quais fazem referencia a uma dire��o qualquer,
		 * dentro de um m�todo add(); de algum conteiner como o JFrame ou
		 * JPanel. Sendo assim teriamos como exemplo:
		 * 
		 * frame.getContentPane().add(button1, BorderLayout.CENTER);
		 * panel.add(button2, BorderLayout.NORTH);
		 */
	
public static void main(String [] args) {
		
		InitFrameAndContents();
		
	}
	
	public static void InitFrameAndContents() {
		
		final int cWIDTH = 50;
		final int cHEIGHT = 50;
		
		JFrame frame = new JFrame("my frame!");
		frame.setPreferredSize(new Dimension(300,300));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.pink);

		
		
		//Criando e adicionando bot�es ao meu JPanel, seguindo a formata��o 
		//padr�o imposto pelo FlowLayout: elementos segmentados em linhas
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(20,20));
		panel.add(button);
		
		JButton button1 = new JButton();
		button1.setPreferredSize(new Dimension(20,20));
		panel.add(button1);
		
		
		
		//Criando JLabel's para cada dire��o do BorderLayout
		JLabel label = new JLabel("my label");
		label.setOpaque(true);
		label.setBackground(Color.cyan);
		label.setPreferredSize(new Dimension(cWIDTH,cHEIGHT));
		
		JLabel label1 = new JLabel("my label 1");
		label1.setOpaque(true);
		label1.setBackground(Color.yellow);
		label1.setPreferredSize(new Dimension(cWIDTH,cHEIGHT));
		
		JLabel label2 = new JLabel("my label 2");
		label2.setOpaque(true);
		label2.setBackground(Color.magenta);
		label2.setPreferredSize(new Dimension(cWIDTH,cHEIGHT));
		
		JLabel label3 = new JLabel("my label 3");
		label3.setOpaque(true);
		label3.setBackground(Color.black);
		label3.setPreferredSize(new Dimension(cWIDTH,cHEIGHT));
		
		
		//Adicionando o JPanel com os bot�es ao ContentPane
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		//Adicionando os JLabel's ao ContentPane, cada um em uma dire��o
		frame.getContentPane().add(label3, BorderLayout.SOUTH);
		frame.getContentPane().add(label2, BorderLayout.NORTH);
		frame.getContentPane().add(label1, BorderLayout.WEST);
		frame.getContentPane().add(label, BorderLayout.EAST);
		
		//Adicionaria em paralelo, n�o seguiria hierarquia**
//		frame.getContentPane().add(label3);
//		frame.getContentPane().add(label2);
//		frame.getContentPane().add(label1);
//		frame.getContentPane().add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
}

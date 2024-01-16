package experiments.testClasses;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContentPaneTesting {

	//O QUE � O Content Pane?
		/*
		 * O Content Pane � uma das �reas do JFrame, um container de alto 
		 * nivel do swing, onde os elementos de interface s�o dispostos.
		 * 
		 * O Content Pane faz parte de uma hierarquia patenteado pelo JFrame
		 * e todos os componentes que est�o contidos nele est�o abaixo dele
		 * nessa "piramide".
		 * 
		 * Para se adicionar algo ao Content Pane, usa-se o m�todo 
		 * getContentPane.add(nomeDoComponente);
		 * 
		 * Para se definir algum elemento como Content Pane, usa-se o m�todo
		 * setContentPane(nomeDoComponente);
		 */
	
	public static void main(String [] args) {
		
		InitFrameAndContents();
		
	}
	
	public static void InitFrameAndContents() {
		
		//Cria um frame com nome e tamanho desejado
		JFrame frame = new JFrame("my frame!");
		frame.setPreferredSize(new Dimension(300,300));
		
		//Cria um painel, capaz de segurar outros componentes, dispondo-os
		//em linhas atrav�s do FlowLayout, LayoutManager padr�o dos JPanel's
		JPanel panel = new JPanel();
		panel.setBackground(Color.pink);
		
		//define o JPanel panel como o Content Pane -painel de conte�do- 
		//do JFrame
		frame.setContentPane(panel);
		
		//Adiciona o JPanel panel ao JFrame em paralelo com o Content Pane, 
		//o que pode dar erro de hierarquia
//		frame.add(panel);
		
		//Cria, configura, e adiciona uma JLabel label ao Content Pane que 
		//agora � o JPanel panel, que est� contido pelo JFrame frame
		JLabel label = new JLabel("comp 1");
		label.setOpaque(true);
		label.setBackground(Color.blue);
		label.setPreferredSize(new Dimension(20,20));
		frame.getContentPane().add(label);//pega o CP e adiciona a label
		
		//Tamb�m cria, configura, e adiciona uma JLabel label2 ao 
		//Content Pane em seguida ao JLabel label atrav�s do FlowLayout.
			//Agora note a disposi��o dos objetos, a sua segmenta��o 
			//� resultado do FlowLayout, que � padr�o do JPanel.
		JLabel label2 = new JLabel("comp 2");
		label2.setOpaque(true);
		label2.setBackground(Color.cyan);
		label2.setPreferredSize(new Dimension(20,20));
		frame.getContentPane().add(label2);//pega CP e adiciona a label
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
}

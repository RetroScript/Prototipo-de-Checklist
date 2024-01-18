package experiments.testClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContentPaneTesting2 extends JPanel{

	//ADICIONANDO AO Content Pane DE OUTRA FORMA!!
		/*
		 * Para se adicionar algo ao Content Pane primeiro é necessário 
		 * considerar a hierarquia entre os componentes internos de um
		 * JFrame, também é importante lembrar que dentro de um Content Pane
		 * entram ainda mais Component's, portanto, aquele seria um "Container"
		 * 
		 * Nessa classe eu vou tentar refazer uma das alternativas de adição
		 * de elementos no JFrame, proposta pelas documentações da Oracle.
		 * 
		 */
	
	public JLabel label;
	
	//Ao instanciar a Classe esse método é chamado. Os atributos e 
	//comportamentos de um método construtor podem ser atribuidos a um
	//Objeto de Natureza Semelhante - que herda uma classe em comum -
	public ContentPaneTesting2() { 
		
		//inicializa e configura a label - que é um Objeto Global-
		label = new JLabel();
		label.setOpaque(true);
		label.setBackground(Color.pink);
		label.setPreferredSize(new Dimension(300,300));
	
		//cria e configura a label2 - que é um Objeto Local -
		JLabel label2 = new JLabel();
		label2.setOpaque(true);
		label2.setBackground(Color.red);
		label2.setPreferredSize(new Dimension(300,300));
	
		
		//Métodos herdados da Classe Pai JPanel: definem o layout como 
		//BorderLayout e adicionam ao painel em suas respectivas posições, 
		//seguindo o Layout desejado.
		setLayout(new BorderLayout());
		add(label, BorderLayout.PAGE_END);
		add(label2, BorderLayout.PAGE_START);
		
	}
	
	public static void initFrame() {
		JFrame frame = new JFrame("ContentPaneTesting2");
		
		//Criação de um novo componente, com os Objetos de Componentes,
		//que servirá como Content Pane. 
		//Define-se como opaco e como Content Pane
		JComponent myContentPane = new ContentPaneTesting2();
		myContentPane.setOpaque(true);
		frame.setContentPane(myContentPane);
		
		//defina para encerrar ao fechar, recalcula o tamanho, fica visível
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		initFrame();
		
	}
	
}

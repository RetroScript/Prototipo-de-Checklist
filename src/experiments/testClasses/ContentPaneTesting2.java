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
		 * Para se adicionar algo ao Content Pane primeiro � necess�rio 
		 * considerar a hierarquia entre os componentes internos de um
		 * JFrame, tamb�m � importante lembrar que dentro de um Content Pane
		 * entram ainda mais Component's, portanto, aquele seria um "Container"
		 * 
		 * Nessa classe eu vou tentar refazer uma das alternativas de adi��o
		 * de elementos no JFrame, proposta pelas documenta��es da Oracle.
		 * 
		 */
	
	public JLabel label;
	
	//Ao instanciar a Classe esse m�todo � chamado. Os atributos e 
	//comportamentos de um m�todo construtor podem ser atribuidos a um
	//Objeto de Natureza Semelhante - que herda uma classe em comum -
	public ContentPaneTesting2() { 
		
		//inicializa e configura a label - que � um Objeto Global-
		label = new JLabel();
		label.setOpaque(true);
		label.setBackground(Color.pink);
		label.setPreferredSize(new Dimension(300,300));
	
		//cria e configura a label2 - que � um Objeto Local -
		JLabel label2 = new JLabel();
		label2.setOpaque(true);
		label2.setBackground(Color.red);
		label2.setPreferredSize(new Dimension(300,300));
	
		
		//M�todos herdados da Classe Pai JPanel: definem o layout como 
		//BorderLayout e adicionam ao painel em suas respectivas posi��es, 
		//seguindo o Layout desejado.
		setLayout(new BorderLayout());
		add(label, BorderLayout.PAGE_END);
		add(label2, BorderLayout.PAGE_START);
		
	}
	
	public static void initFrame() {
		JFrame frame = new JFrame("ContentPaneTesting2");
		
		//Cria��o de um novo componente, com os Objetos de Componentes,
		//que servir� como Content Pane. 
		//Define-se como opaco e como Content Pane
		JComponent myContentPane = new ContentPaneTesting2();
		myContentPane.setOpaque(true);
		frame.setContentPane(myContentPane);
		
		//defina para encerrar ao fechar, recalcula o tamanho, fica vis�vel
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		initFrame();
		
	}
	
}

package experiments.testClasses;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxTesting2 extends JPanel implements ActionListener{

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

	private static final long serialVersionUID = 1L;
	public JLabel label;
	
	public ComboBoxTesting2() {
		
		String stringOptions[] = {"option1", "option2", "option3"};
		
		JComboBox cb = new JComboBox(stringOptions);
		cb.setPreferredSize(new Dimension(300,300));
		
		add(cb);
		
	}
	
	public static void main(String [] args) {
		
//		ComboBoxTesting cbTest = new ComboBoxTesting();
		
		createAndShowGUI();
		
	}
	
	public static void createAndShowGUI() {
		
		JFrame frame = new JFrame("ComboBoxTesting");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComponent contentPane = new ComboBoxTesting2();
		contentPane.setOpaque(true);
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void updateLabel() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	 
		
	}

}

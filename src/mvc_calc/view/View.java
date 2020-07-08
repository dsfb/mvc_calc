package mvc_calc.view;

import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import mvc_calc.model.Model;

import javax.swing.JComboBox;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null; // @jve:decl-index=0:visual-constraint="105,58"

	protected JTextField num1Field = null;

	protected JTextField num2Field = null;

	private JButton equalButton = null;

	protected JTextField resultField = null;

	private JComboBox<String> comboOperacoes = null;

	private NumberListener listener = new NumberListener();
	
	/**
	 * This is the default constructor
	 */
	public View() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(450, 95);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method is based on: https://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
	 */
	private void initializeElements() {
		num1Field = new JTextField();
		num1Field.setBounds(new Rectangle(11, 16, 49, 20));
		
		// Listen for changes in the text
		num1Field.getDocument().addDocumentListener(this.listener);
		
		num2Field = new JTextField();
		num2Field.setBounds(new Rectangle(113, 16, 50, 20));
		
		// Listen for changes in the text
		num2Field.getDocument().addDocumentListener(this.listener);
		
		equalButton = new JButton();
		equalButton.setBounds(new Rectangle(174, 14, 54, 26));
		equalButton.setText("=");
		equalButton.setEnabled(false);
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getNum1Field(), null);
			jContentPane.add(getNum2Field(), null);
			jContentPane.add(getEqualButton(), null);
			jContentPane.add(getResultField(), null);
			jContentPane.add(getComboOperacoes(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes num1Field
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getNum1Field() {
		return num1Field;
	}

	/**
	 * This method initializes num2Field
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getNum2Field() {
		return num2Field;
	}

	/**
	 * This method initializes equalButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getEqualButton() {
		return equalButton;
	}

	/**
	 * This method initializes resultField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getResultField() {
		if (resultField == null) {
			resultField = new JTextField();
			resultField.setBounds(new Rectangle(243, 17, 154, 25));
		}
		return resultField;
	}

	/**
	 * This method initializes comboOperacoes
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox<String> getComboOperacoes() {
		if (comboOperacoes == null) {
			comboOperacoes = new JComboBox<>(new String[] { "+", "-", "/", "*" });
			comboOperacoes.setBounds(new Rectangle(66, 17, 38, 20));
		}
		comboOperacoes.setActionCommand("combo");
		return comboOperacoes;
	}

	//
	// Mecanismo de Leitura/Escrita do Modelo
	//
	public void escreveModelo(Model modelo) {
		Double num1 = modelo.getNum1();
		Double num2 = modelo.getNum2();
		Double result = modelo.getResult();

		num1Field.setText(num1.toString());
		num2Field.setText(num2.toString());
		resultField.setText(result.toString());
	}

	public Model leModelo() {
		String num1s = num1Field.getText();
		String num2s = num2Field.getText();
		String results = resultField.getText();
		String operacao = (String) (comboOperacoes.getSelectedItem());
		try {
			Double num1 = null;
			Double num2 = null;
			Double result = null;

			if (!num1s.equals(""))
				num1 = Double.parseDouble(num1s);
			if (!num2s.equals(""))
				num2 = Double.parseDouble(num2s);
			if (!results.equals(""))
				result = Double.parseDouble(results);

			Model m = new Model();
			m.setNum1(num1);
			m.setNum2(num2);
			m.setResult(result);
			m.setOperacao(operacao);

			return m;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Entrada Inválida");
			return null;
		}
	}

	//
	// Mecanismo de Configuração do(s) Ouvinte(s)
	//
	public void configuraOuvinte(ActionListener ouvinte) {
		equalButton.addActionListener(ouvinte);
	}
}

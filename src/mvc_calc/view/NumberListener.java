package mvc_calc.view;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import mvc_calc.model.Model;

public class NumberListener implements DocumentListener {

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		
	}
	
	public void process() {
		Model m = visao.leModelo();

		Double num1 = m.getNum1();
		Double num2 = m.getNum2();
		String operacao = m.getOperacao();

		Double result;
		if (operacao.equals("+")) {
			result = num1 + num2;
		} else if (operacao.equals("-")) {
			result = num1 - num2;
		} else if (operacao.equals("*")) {
			result = num1 * num2;
		} else {
			result = num1 / num2;
		}

		m.setResult(result);

		visao.escreveModelo(m);
	}
}

package mvc_calc.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc_calc.modelo.Modelo;

import mvc_calc.visao.Visao;

public class Controle implements ActionListener {
	private Visao visao;

	public Controle(Visao visao) {
		this.visao = visao;
		visao.configuraOuvinte(this);
		this.inicia();
	}

	public void inicia() {
		visao.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("equal")) {

			Modelo m = visao.leModelo();

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
}

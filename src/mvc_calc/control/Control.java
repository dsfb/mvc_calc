package mvc_calc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc_calc.model.Model;
import mvc_calc.view.View;

public class Control implements ActionListener {
	private View visao;

	public Control(View visao) {
		this.visao = visao;
		visao.configuraOuvinte(this);
		this.inicia();
	}

	public void inicia() {
		visao.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("equal")) {

			
		}
	}
}

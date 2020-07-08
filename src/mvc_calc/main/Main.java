package mvc_calc.main;

import mvc_calc.visao.Visao;
import mvc_calc.controle.Controle;

public class Main {

	public static void main(String[] args) {
		new Controle(new Visao());
	}

}

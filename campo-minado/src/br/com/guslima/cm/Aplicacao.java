package br.com.guslima.cm;

import br.com.guslima.cm.model.Tabuleiro;
import br.com.guslima.cm.view.TabuleiroConsole;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
		
	}
}
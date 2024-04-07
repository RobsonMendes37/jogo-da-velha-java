public class ControladorJogo {
	private JogoDaVelha JogoDaVelha1;

	public ControladorJogo() {
		JogoDaVelha1 = new JogoDaVelha(); 						  
	}

	public void fazJogada(int linha, int coluna) {

		JogoDaVelha1.fazJogada(linha,coluna);
	}

	public int[][] mostrarTabuleiro(){
		return JogoDaVelha1.mostrarTabuleiro();
	} 

	public boolean verificarFimDeJogo() {
		return JogoDaVelha1.verificarFimDeJogo();
	}

	public void apagarTabuleiro(){
		JogoDaVelha1.apagarTabuleiro();
	}
	
	public void realizarVezDaMaquina(){
		JogoDaVelha1.realizarVezDaMaquina();
	}
	public int amostrarVencedor(){
		return JogoDaVelha1.amostrarVencendor();
	}
	public void verificarVencedor(){
		JogoDaVelha1.verificarVencedor();
	}
	public void novoJogo(){
		JogoDaVelha1.verificarFimDeJogo();
	}
}

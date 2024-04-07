import java.security.InvalidParameterException;
import java.util.Random;

public class JogoDaVelha {

	private int jogadorVencedor;
	private int contadorDeJogadas;
	private int jogadorDaVez;
	private int[][] tabuleiro;
	public boolean casaOcupada;

	public JogoDaVelha() {
		jogadorDaVez = 1;
		jogadorVencedor = 0;
		contadorDeJogadas = 0;
		tabuleiro = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = 0;
			}
		}
	}

	public void fazJogada(int linha, int coluna) {
		if (jogadorDaVez == 1) {
			if (tabuleiro[linha][coluna] == 0) {
				tabuleiro[linha][coluna] = 1;
				contadorDeJogadas++;
				jogadorDaVez = 2;
				return;
			} else {
				jogadorDaVez = 1;
				casaOcupada = true;
				System.out.println("#Jogada Invalida--Casa Já está Ocupada!#");
			}
		}
	}

	public int[][] mostrarTabuleiro() {
		return tabuleiro;
	}

	public void realizarVezDaMaquina() {
		Random random = new Random();

		if (jogadorDaVez == 2) {
			System.out.println("Maquina Realiza jogada:");
			boolean jogou = false;
			int linha = random.nextInt(3);
			int coluna = random.nextInt(3);

			while (!jogou) {
				if (tabuleiro[linha][coluna] == 0) {
					tabuleiro[linha][coluna] = -2;
					jogadorDaVez = 1;
					jogou = true;
				} else {
					linha = random.nextInt(3);
					coluna = random.nextInt(3);
				}
			}
		}
	}

	public void verificarVencedor() {
		if (tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2] == 3) {
			jogadorVencedor = 1;
		} else if (tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2] == -6) {
			jogadorVencedor = 2;
		} else if (tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2] == 3) {
			jogadorVencedor = 1;
		} else if (tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2] == -6) {
			jogadorVencedor = 2;
		} else if (tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2] == 3) {
			jogadorVencedor = 1;
		} else if (tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2] == -6) {
			jogadorVencedor = 2;
		} else if (tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0] == 3) {
			jogadorVencedor = 1;
		} else if (tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0] == -6) {
			jogadorVencedor = 2;
		} else if (tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1] == 3) {
			jogadorVencedor = 1;
		} else if (tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1] == -6) {
			jogadorVencedor = 2;
		} else if (tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2] == 3) {
			jogadorVencedor = 1;
		} else if (tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2] == -6) {
			jogadorVencedor = 2;
		} else if (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2] == 3) {
			jogadorVencedor = 1;
		} else if (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2] == -6) {
			jogadorVencedor = 2;
		} else if (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0] == 3) {
			jogadorVencedor = 1;
		} else if (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2] == -6) {
			jogadorVencedor = 2;
		} else if (contadorDeJogadas == 9) {
			jogadorVencedor = 3;
		}
	}

	public int amostrarVencendor() {
		if (jogadorVencedor == 0) {
			return -888;
		} else
			return jogadorVencedor;
	}

	public boolean verificarFimDeJogo() {
		return jogadorVencedor != 0;
	}

	public void novoJogo() {
		jogadorVencedor = 0;
	}

	public void apagarTabuleiro() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = 0;
			}
		}
		jogadorDaVez = 1;
		jogadorVencedor = 0;
		contadorDeJogadas = 0;
		return;
	}
}

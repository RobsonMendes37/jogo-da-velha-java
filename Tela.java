import java.util.Scanner;

public class Tela {
	Scanner scanner = new Scanner(System.in);

	private ControladorJogo controladorJogo1;

	public Tela() {
		controladorJogo1 = new ControladorJogo();
	}

	public void jogar() {
		System.out.println("Bem vindo ao Jogo Da Velha!");

		while (true) {
			mostrarTabuleiro();
			fazJogada();
			mostrarVencedor();
			if (!controladorJogo1.verificarFimDeJogo()){ 
				realizarVezDaMaquina();
			}
			if (!jogarNovamente()){ 
				break;
			}
		}
	}

	public void mostrarTabuleiro() {
		int[][] newTabuleiro = controladorJogo1.mostrarTabuleiro();

		System.out.println("   0   1   2");

		for (int i = 0; i < 3; i++) {
			System.out.print(i + " ");

			for (int j = 0; j < 3; j++) {
				if (newTabuleiro[i][j] == 1) {
					System.out.print(" X ");
				} else if (newTabuleiro[i][j] == -2) {
					System.out.print(" O ");
				} else {
					System.out.print("   ");
				}

				if (j < 2) {
					System.out.print("|");
				}
			}
			System.out.println();

			if (i < 2) {
				System.out.println("  ---+---+---");
			}
		}

	}

	public void mostrarVencedor() {
		controladorJogo1.verificarVencedor();

		if (controladorJogo1.verificarFimDeJogo()) {

			int vencedor = controladorJogo1.amostrarVencedor();

			if (vencedor == 1) {
				System.out.println("Você venceu! Parabéns! \nTemos alguem que realmente se esforçou pra não errar.Risos!!!");
			} else if (vencedor == 2) {
				System.out.println("A máquina venceu. Melhor sorte na próxima vez.\n Nem pra isso você serve! Lixo");
			} else {
				System.out.println("Empate! O jogo terminou sem vencedor.\nTal pai,tal filho, dois lixos!!");
			}
			mostrarTabuleiro();
		}
	}

	public void fazJogada() {
		int linha=-999;
		int coluna=-999;
		boolean existeErro=false;
		do{
			try {
				System.out.print("----Faça sua Jogada---- \nLinha: ");
				linha = Integer.parseInt(scanner.nextLine());//transformar pra receber uma string
				
				if (linha != 0 && linha != 1 && linha != 2) {
					
					throw new Exception("####Entrada Inválida linha####\nEscolha Indices entre 0,1,2");
					
				}

				System.out.print("Coluna: ");
				coluna = Integer.parseInt(scanner.nextLine());

				if (coluna != 0 && coluna != 1 && coluna != 2) {
					
					throw new Exception("####Entrada Inválida coluna####\nEscolha Indices entre 0,1,2");
					
				}
				existeErro=false;
			} catch (Exception erro) {
				existeErro=true;
				System.out.println("Aconteceu um Erro: " + erro.getMessage());
			}
		
	}while(existeErro);

	controladorJogo1.fazJogada(linha, coluna);
	}


	public void realizarVezDaMaquina() {
		controladorJogo1.realizarVezDaMaquina();
	}

	public boolean jogarNovamente() {
		
		if (controladorJogo1.verificarFimDeJogo()) {
			
				System.out.println("Deseja jogar novamente? Sim ou Nao)");
				String resposta = scanner.nextLine();

				System.out.println("Saida foi: " + resposta);
				if (resposta.equals("sim")  || resposta.equals("Sim")) {
					controladorJogo1.apagarTabuleiro();
					controladorJogo1.novoJogo();
					jogar();
					return true; 

				} else if (resposta.equals("nao")  || resposta.equals("Nao")){
					System.out.println("Obrigado por jogar! Até a próxima.");
					System.exit(0);
				}	
				System.out.println("Comando inválido");
			
		}
		return true;
	}
}

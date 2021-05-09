package classes;

public class Damas {

	Tabuleiro tabuleiro;
	Jogador jogador1;
	Jogador jogador2;

	// Construtor que recebe um objeto tabuleiro e dois jogadores.
	public Damas(Tabuleiro t, Jogador j1, Jogador j2) {
		this.tabuleiro = t;
		this.jogador1 = j1;
		this.jogador2 = j2;
	}

	// Imprime as informações do jogo
	public void imprimir() {
		this.tabuleiro.imprimirConfiguracaoAtual();
		System.out.println("\n\n\n");
	}

	// Faz uma movimentação no jogo. Ao final da execução deste método uma peça terá
	// movido de lugar ou deverá ter uma mensagem informando a razão do movimento
	// não
	// ter sido realizado.
	public void jogar(Jogador jogador, Peca nomePeca, String posicao) {
		if (this.jogador1.Nome == jogador.Nome || this.jogador2.Nome == jogador.Nome) {
			if (this.jogador1.corPeca == nomePeca.cor) {
				if(this.tabuleiro.isMovimentoValido(posicao, nomePeca)) {
					this.tabuleiro.isMovimentoEliminatorio(nomePeca, posicao);
				}
			} else if (this.jogador2.corPeca == nomePeca.cor) {
				if(this.tabuleiro.isMovimentoValido(posicao, nomePeca)) {
					this.tabuleiro.isMovimentoEliminatorio(nomePeca, posicao);
				}
			}
		}
	}

}

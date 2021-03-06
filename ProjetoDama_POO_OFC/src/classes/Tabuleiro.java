package classes;

import java.util.ArrayList;

public class Tabuleiro {

	// Lista contendo objetos do tipo pe?a
	ArrayList<Peca> pecas = new ArrayList<>();
	ArrayList<String> sup = new ArrayList<>();
	String tabu[][] = new String[8][8];
	boolean movimentoEliminatorio = false;
	int posicaoAntigaX = 0;
	int posicaoAntigaY = 0;
	int posicaoNovaX = 0;
	int posicaoNovaY = 0;

	public Tabuleiro() {
		for (int l = 0; l < 8; l++) {
			for (int c = 0; c < 8; c++) {
				this.tabu[l][c] = "*";
			}
		}
	}

	public void adicionar(Peca p) {
		if (p.posicaoAtualX < 8 && p.posicaoAtualY < 8 && this.tabu[p.posicaoAtualX][p.posicaoAtualY] == "*") {
			this.tabu[p.posicaoAtualX][p.posicaoAtualY] = p.nome;
			this.pecas.add(p);
		} else {
			System.out.println("N?o foi possivel adicionar a peca: " + p.nome);
		}
	}

	// Verifica se o movimento realizado obedece os limites f?sicos do tabuleiro.
	public boolean isMovimentoValido(String posicao, Peca peca) {
		if (this.tabu[peca.posicaoAtualX][peca.posicaoAtualY] == peca.nome) {
			if (Character.getNumericValue(posicao.charAt(0)) < 8 && Character.getNumericValue(posicao.charAt(1)) < 8
					&& this.tabu[Character.getNumericValue(posicao.charAt(0))][Character
							.getNumericValue(posicao.charAt(1))] == "*") {
				if (Character.getNumericValue(posicao.charAt(0)) < peca.posicaoAtualX && peca.cor == "Branca"
						&& (Character.getNumericValue(posicao.charAt(1)) - 1) == peca.posicaoAtualY
						|| (Character.getNumericValue(posicao.charAt(1)) + 1) == peca.posicaoAtualY
								&& (Character.getNumericValue(posicao.charAt(0)) - 1) == peca.posicaoAtualX
						|| (Character.getNumericValue(posicao.charAt(0)) + 1) == peca.posicaoAtualX) {

					this.tabu[peca.posicaoAtualX][peca.posicaoAtualY] = "*";
					peca.atualizarPosicao(posicao);
					this.tabu[peca.posicaoAtualX][peca.posicaoAtualY] = peca.nome;

					return true;
				} else if (Character.getNumericValue(posicao.charAt(0)) > peca.posicaoAtualX && peca.cor == "Preta"
						&& (Character.getNumericValue(posicao.charAt(1)) - 1) == peca.posicaoAtualY
						|| (Character.getNumericValue(posicao.charAt(1)) + 1) == peca.posicaoAtualY
								&& (Character.getNumericValue(posicao.charAt(0)) - 1) == peca.posicaoAtualX
						|| (Character.getNumericValue(posicao.charAt(0)) + 1) == peca.posicaoAtualX) {

					this.tabu[peca.posicaoAtualX][peca.posicaoAtualY] = "*";
					peca.atualizarPosicao(posicao);
					this.tabu[peca.posicaoAtualX][peca.posicaoAtualY] = peca.nome;

					return true;
				} else {
					System.out.println("Movimento invalido!");
					return false;
				}
			} else if (this.tabu[Character.getNumericValue(posicao.charAt(0))][Character
					.getNumericValue(posicao.charAt(1))] != "*" && Character.getNumericValue(posicao.charAt(0)) < 8
					&& Character.getNumericValue(posicao.charAt(1)) < 8) {

				this.movimentoEliminatorio = true;
				return true;
			} else {
				System.out.println("Coordenadas n?o atendem aos limites fisicos do tabuleiro !");
				return false;
			}
		} else {
			System.out.println("peca ja eliminada !");
			return false;
		}
	}

	// Imprime o status atual do jogo. Deve ser mostrado as posi??es atuais de cada
	// pe?a.
	public void imprimirConfiguracaoAtual() {
		for (int l = 0; l < 8; l++) {
			System.out.println("\n");
			for (int c = 0; c < 8; c++) {
				System.out.print(tabu[l][c] + "\t");
			}
		}
	}

	// Verifica se o movimento eliminou a pe?a do advers?rio
	public boolean isMovimentoEliminatorio(Peca peca, String posicao) {
		if (this.movimentoEliminatorio == true) {
			this.tabu[peca.posicaoAtualX][peca.posicaoAtualY] = "*";
			this.posicaoAntigaX = peca.posicaoAtualX;
			this.posicaoAntigaY = peca.posicaoAtualY;
			peca.atualizarPosicao(posicao);
			this.sup.add(tabu[peca.posicaoAtualX][peca.posicaoAtualY]);
			this.tabu[peca.posicaoAtualX][peca.posicaoAtualY] = "*";
			if (Character.getNumericValue(posicao.charAt(0)) < this.posicaoAntigaX
					&& Character.getNumericValue(posicao.charAt(1)) > this.posicaoAntigaY) {
				this.tabu[peca.posicaoAtualX - 1][peca.posicaoAtualY + 1] = peca.nome;
			} else if (Character.getNumericValue(posicao.charAt(0)) > this.posicaoAntigaX
					&& Character.getNumericValue(posicao.charAt(1)) < this.posicaoAntigaY) {
				this.tabu[peca.posicaoAtualX + 1][peca.posicaoAtualY - 1] = peca.nome;
			} else if (Character.getNumericValue(posicao.charAt(0)) > this.posicaoAntigaX
					&& Character.getNumericValue(posicao.charAt(1)) > this.posicaoAntigaY) {
				this.tabu[peca.posicaoAtualX + 1][peca.posicaoAtualY + 1] = peca.nome;
			} else if (Character.getNumericValue(posicao.charAt(0)) < this.posicaoAntigaX
					&& Character.getNumericValue(posicao.charAt(1)) < this.posicaoAntigaY) {
				this.tabu[peca.posicaoAtualX - 1][peca.posicaoAtualY - 1] = peca.nome;
			}else {
				System.out.println("Some exception ocurred !");
			}

			return true;
		} else {
			return false;
		}
	}

	// Remove a pe?a do jogo.
	public void remover(Peca p) {
		this.pecas.remove(p);
	}

}

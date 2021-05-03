package classes;

public class Damas {
	
	Tabuleiro tabuleiro;
	Jogador jogador1;
	Jogador jogador2;
	
	// Construtor que recebe um objeto tabuleiro e dois jogadores.
	public Damas (Tabuleiro t, Jogador j1, Jogador j2)
	{
		this.tabuleiro = t;
		this.jogador1 = j1;
		this.jogador2 = j2;
	}
	
	public void adicionar (Tabuleiro tabuleiro)
	{
		
	}
	
	public void adicionar (Jogador jogador)
	{
		
	}
	
	//Imprime as informa��es do jogo
	public void imprimir()
	{
		this.tabuleiro.imprimirConfiguracaoAtual();
	}
	
	//Faz uma movimenta��o no jogo. Ao final da execu��o deste m�todo uma pe�a ter� 
	//movido de lugar ou dever� ter uma mensagem informando a raz�o do movimento n�o 
	//ter sido realizado.
	public void jogar(Jogador jogador, Peca nomePeca, String posicao)
	{
		if(this.jogador1.Nome == jogador.Nome || this.jogador2.Nome == jogador.Nome) {
			if(this.jogador1.corPeca == nomePeca.cor) {
				this.tabuleiro.isMovimentoValido(posicao,nomePeca);
			}else if(this.jogador2.corPeca == nomePeca.cor) {
				this.tabuleiro.isMovimentoValido(posicao,nomePeca);
			}
		}
	}
	
	
	
	
	
	
	

}

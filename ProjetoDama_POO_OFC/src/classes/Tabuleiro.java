package classes;

import java.util.ArrayList;

public class Tabuleiro {
	
	//Lista contendo objetos do tipo pe�a
	ArrayList <Peca> pecas = new ArrayList<>();
	String tabu[][] = new String[8][8];
	
	public Tabuleiro()
	{
		for(int l = 0; l < 8; l++)
		{
			for(int c = 0; c < 8; c++)
			{	
				tabu[l][c] = "*";
			}
		}
	}
	
	public void adicionar(Peca p)
	{
		if(p.posicaoAtualX < 8 && p.posicaoAtualY < 8 && this.tabu[p.posicaoAtualX][p.posicaoAtualY] == "*") {
			this.tabu[p.posicaoAtualX][p.posicaoAtualY] = p.nome;
			this.pecas.add(p);
		}else {
			System.out.println("N�o foi possivel adicionar a peca: "+p.nome);
		}
	}
	
	//Verifica se o movimento realizado obedece os limites f�sicos do tabuleiro.
	public boolean isMovimentoValido(String posicao,Peca posicaoPeca)
	{
		if(Character.getNumericValue(posicao.charAt(0)) < 8 && Character.getNumericValue(posicao.charAt(1)) < 8 
				&& this.tabu[Character.getNumericValue(posicao.charAt(0))][Character.getNumericValue(posicao.charAt(1))] == "*") {
			return true;
		}else {
			return false;
		}
	}
	
	//Imprime o status atual do jogo. Deve ser mostrado as posi��es atuais de cada pe�a.
	public void imprimirConfiguracaoAtual()
	{
		for(int l = 0; l < 8; l++)
		{
			System.out.println("\n");
			for(int c = 0; c < 8; c++)
			{	
				System.out.print(tabu[l][c] + "\t");
			}
		}
	}
	
	//Verifica se o movimento eliminou a pe�a do advers�rio
	public boolean isMovimentoEliminatorio(Peca p, String posicao)
	{
		return true;
	}
	
	//Remove a pe�a do jogo.
	public void remover(Peca p)
	{
		
	}
	

}

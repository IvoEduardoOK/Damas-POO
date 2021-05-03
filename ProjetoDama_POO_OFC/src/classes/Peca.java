package classes;

public abstract class Peca {

	String nome;
	String cor;
	int posicaoAtualX;
	int posicaoAtualY;
	
	//Construtor que recebe um nome, uma cor e uma posi��o inicial.
	public Peca(String nome, String cor, String posicao)
	{
		this.nome = nome;
		this.cor = cor;
		this.posicaoAtualX = Character.getNumericValue(posicao.charAt(0));
		this.posicaoAtualY = Character.getNumericValue(posicao.charAt(1));
	}
	
	
	public void atualizarPosicao(String posicao)
	{
		this.posicaoAtualX = Character.getNumericValue(posicao.charAt(0));
		this.posicaoAtualY = Character.getNumericValue(posicao.charAt(1));
	}
	
	public String toString() {
		return this.nome;
	}
	

	
	//M�todo abstrato para verificar se a posi��o solicitada � 
	//v�lida dado as regras de movimenta��o daquela pe�a.
	public abstract boolean isMovimentoValido(String posicao);
	
	
	
	
	
	
}

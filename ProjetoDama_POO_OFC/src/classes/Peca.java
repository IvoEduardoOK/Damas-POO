package classes;

public abstract class Peca {

	String nome;
	String cor;
	int posicaoAtualX;
	int posicaoAtualY;
	
	//Construtor que recebe um nome, uma cor e uma posição inicial.
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
	

	
	//Método abstrato para verificar se a posição solicitada é 
	//válida dado as regras de movimentação daquela peça.
	public abstract boolean isMovimentoValido(String posicao);
	
	
	
	
	
	
}

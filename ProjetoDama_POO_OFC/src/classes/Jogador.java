package classes;

import java.util.ArrayList;

import Classes_3.Peca;

public class Jogador {
	
	String Nome;
	String corPeca;
	ArrayList<Peca> pecasAdquiridas = new ArrayList<>();
	double pontuacao;
	
	//Construtor que recebe um nome e uma cor de pe�a
	public Jogador(String nome, String corPeca)
	{
		this.Nome = nome;
		this.corPeca = corPeca;
	}
	
	//Retorna uma lista contendo as pe�as do advers�rio 
	//que foram adquiridas ao longo da partida.
	public ArrayList <Peca> listarPecasAdquiridas(Peca comida)
	{
		this.pecasAdquiridas.add(comida);
		return this.pecasAdquiridas;
	}
	
	public double getPontuacao() {
		for(int i = 0;i < pecasAdquiridas.size();i++) {
			this.pontuacao +=1;
		}
		return this.pontuacao;
	}

}

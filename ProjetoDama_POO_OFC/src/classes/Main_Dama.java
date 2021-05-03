package classes;

public class Main_Dama {

	public static void main(String[] args) {
		
		Tabuleiro tabu = new Tabuleiro();

		
		Peca b1 = new PecaSimples("B1","Branca","42");
		Peca b2 = new PecaSimples("B2","Branca","41");
		Peca p1 = new PecaSimples("P1","Preta","15");
		Peca p2 = new PecaSimples("P2","Preta","14");
		
		tabu.adicionar(b1);
//		tabu.adicionar(b2);
//		tabu.adicionar(p1);
//		tabu.adicionar(p2);
		
		Jogador j1 = new Jogador("Cleito","Branca");
		Jogador j2 = new Jogador("Cleber","Preta");
		
		Damas jogo = new Damas(tabu,j1,j2);
		
		jogo.imprimir();
		jogo.jogar(j1, b1, "53");
		
	}

}

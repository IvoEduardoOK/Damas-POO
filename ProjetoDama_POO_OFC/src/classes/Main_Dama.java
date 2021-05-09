package classes;

public class Main_Dama {

	public static void main(String[] args) {
		
		Tabuleiro tabu = new Tabuleiro();

		
		Peca b1 = new PecaSimples("B1","Branca","41");
		Peca b2 = new PecaSimples("B2","Branca","42");
		Peca p1 = new PecaSimples("P1","Preta","15");
		Peca p2 = new PecaSimples("P2","Preta","14");
		
		tabu.adicionar(b1);
		tabu.adicionar(b2);
		tabu.adicionar(p1);
		tabu.adicionar(p2);
		
		Jogador j1 = new Jogador("Cleito","Branca");
		Jogador j2 = new Jogador("Cleber","Preta");
		
		Damas jogo = new Damas(tabu,j1,j2);
		
		jogo.imprimir();
		jogo.jogar(j1, b1, "32");
		jogo.jogar(j1, b2, "33");
		jogo.jogar(j2,p1,"24");
		jogo.jogar(j2, p2, "25");
		jogo.imprimir();
		jogo.jogar(j2,p2,"36");
		jogo.jogar(j1, b1, "21");
		jogo.imprimir();
		jogo.jogar(j1, b2, "24");
		jogo.imprimir();
		
	}

}

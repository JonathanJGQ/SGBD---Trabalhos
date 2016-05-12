package transacoes;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Grafo g = new Grafo(); // Inicializa grafo vazio		
		System.out.println("Grafo vazio criado");
		
		System.out.println("\n(1) TR_Begin");
		System.out.println("(2) Sair");
		
		int opcao = new Scanner(System.in).nextInt();
		
		switch (opcao) {
		
		case 1:
		{
			Transacao t = new Transacao();
			g.criarTransacao(t);
			g.adicionarVertice(t.getEstado());

			Menu m = new Menu(g, t);
			m.eventos();
		}
		break;
		
		case 2:
			System.exit(0);
			break;
			
		default:
			System.out.println("\nOpção inválida!");
		}
	}

}

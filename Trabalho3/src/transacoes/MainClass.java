package transacoes;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Grafo g = new Grafo(); // Inicializa grafo vazio, sem transações	
		System.out.println("Grafo vazio criado");
		
		System.out.println("\n(1) TR_Begin");
		System.out.println("(2) Sair");
		
		int opcao = new Scanner(System.in).nextInt();
		
		switch (opcao) {
		
		case 1:
		{
			System.out.print("\nDefina um id para essa transação: ");
			String id = new Scanner(System.in).nextLine();
			
			if (!g.transacaoExiste(id)) {
				TrManager.addTs();
				Transacao t = new Transacao(id,TrManager.getTs());
				g.criarTransacao(t);
				g.estadoTransacoes();
				
				Menu m = new Menu(g, t);
				m.eventos();
			}
			else {
				System.out.println("\nTransação já existe");
			}
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

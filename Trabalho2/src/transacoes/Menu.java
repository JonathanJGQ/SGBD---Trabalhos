package transacoes;

import java.util.Scanner;

public class Menu {
	
	Grafo g;
	Transacao t;
	
	public Menu(Grafo g, Transacao t) {
		this.g = g;
		this.t = t;
	}
	
	public void eventos() {
		
		int estado = t.getEstado();
		
		switch (estado) {
		
		case 1:
		{
			System.out.println("\nEstado atual: TR_INICIADA");

			System.out.println("\n(1) READ");
			System.out.println("(2) WRITE");
			System.out.println("(3) Criar nova transação");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				t.setEstado(Transacao.ATIVA);
				g.adicionarVertice(t.getEstado());
				g.estadoTransacoes();
				g.imprimir();
				this.eventos();
			}
			else if (opcao == 2) {
				t.setEstado(Transacao.ATIVA);
				g.adicionarVertice(t.getEstado());
				g.estadoTransacoes();
				g.imprimir();
				this.eventos();
			}
			else if (opcao == 3) {
				this.novaTransacao();
			}
			else {
				System.out.println("Opção inválida!");
			}
			
		}
		break;
		
		case 2:
		{
			System.out.println("\nEstado atual: ATIVA");

			System.out.println("\n(1) READ");
			System.out.println("(2) WRITE");
			System.out.println("(3) TR_Terminate");
			System.out.println("(4) TR_Rollback");
			System.out.println("(5) Criar nova transação");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				t.setEstado(Transacao.ATIVA);
				g.adicionarVertice(t.getEstado());
				g.estadoTransacoes();
				g.imprimir();
				this.eventos();
			}
			else if (opcao == 2) {
				t.setEstado(Transacao.ATIVA);
				g.adicionarVertice(t.getEstado());
				g.estadoTransacoes();
				g.imprimir();
				this.eventos();
			}
			else if (opcao == 3) {
				t.setEstado(Transacao.PROCESSO_EFETIVACAO);
				g.adicionarVertice(t.getEstado());
				g.estadoTransacoes();
				g.imprimir();
				this.eventos();
			}
			else if (opcao == 4) {
				t.setEstado(Transacao.PROCESSO_CANCELAMENTO);
				g.adicionarVertice(t.getEstado());
				g.estadoTransacoes();
				g.imprimir();
				this.eventos();
			}
			else if (opcao == 5) {
				this.novaTransacao();
			}
			else {
				System.out.println("Opção inválida!");
			}
			
		}
		break;
		
		case 3:
		{
			System.out.println("\nEstado atual: PROCESSO_CANCELAMENTO");

			System.out.println("\n(1) TR_Finish");
			System.out.println("(2) Criar nova transação");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				t.setEstado(Transacao.TR_FINALIZADA);
				System.out.println("\nTransação finalizada");
				g.adicionarVertice(t.getEstado());
				g.estadoTransacoes();
				g.imprimir();
				this.eventos();
			}
			else if (opcao == 2) {
				this.novaTransacao();
			}
			else {
				System.out.println("Opção inválida!");
			}

		}
		break;
		
		case 4:
		{			
			System.out.println("\nEstado atual: PROCESSO_EFETIVACAO");

			System.out.println("\n(1) TR_Rollback");
			System.out.println("(2) TR_Commit");
			System.out.println("(3) Criar nova transação");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				t.setEstado(Transacao.PROCESSO_CANCELAMENTO);
				g.adicionarVertice(t.getEstado());
				g.estadoTransacoes();
				g.imprimir();
				this.eventos();
			}
			else if (opcao == 2) {
				t.setEstado(Transacao.EFETIVADA);
				g.adicionarVertice(t.getEstado());
				g.estadoTransacoes();
				g.imprimir();
				this.eventos();
			}
			else if (opcao == 3) {
				this.novaTransacao();
			}
			else {
				System.out.println("Opção inválida!");
			}

		}
		break;
		
		case 5:
		{	
			System.out.println("\nEstado atual: EFETIVADA");

			System.out.println("\n(1) TR_Finish");
			System.out.println("(2) Criar nova transação");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				t.setEstado(Transacao.TR_FINALIZADA);
				System.out.println("\nTransação finalizada");
				g.adicionarVertice(t.getEstado());
				g.estadoTransacoes();
				g.imprimir();
				this.eventos();
			}
			else if (opcao == 2) {
				this.novaTransacao();
			}
			else {
				System.out.println("Opção inválida!");
			}

		}
		break;
		
		case 6:
		{
			System.out.println("\nEstado atual: TR_FINALIZADA");
			
			System.out.println("\n(1) Criar nova transação");
			System.out.println("(2) Sair");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				this.novaTransacao();
			}
			else if (opcao == 2) {
				System.exit(0);
			}
			else {
				System.out.println("Opção inválida!");
			}

		}
		
		}
		
	}
	
	public void novaTransacao() {
		Transacao novaT = new Transacao();
		g.criarTransacao(novaT);
		Menu m = new Menu(g, novaT);
		m.eventos();
	}
}

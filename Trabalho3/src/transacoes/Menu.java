package transacoes;

import java.util.Scanner;

public class Menu {
	
	Grafo g;
	Transacao t;
	LockManager lm = new LockManager();
	
	public Menu(Grafo g, Transacao t) {
		this.g = g;
		this.t = t;
	}
	
	public void eventos() {
		
		String estado = t.getEstado();
		
		switch (estado) {
		
		case "TR_INICIADA":
		{
			System.out.println("\nEstado atual da transação " + t.getId() + ": TR_INICIADA");

			System.out.println("\n(1) READ");
			System.out.println("(2) WRITE");
			System.out.println("(3) TR_Begin");
			System.out.println("(4) Mudar transação");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				System.out.println("Escolha o item a ser lido: ");
				String dado = new Scanner(System.in).next();
				Item item = new Item(dado);
				if(lm.LS(t, item)){
					t.setEstado(g.vertices.get(g.vertices.indexOf(Grafo.ATIVA)));
				}
				g.estadoTransacoes();
				eventos();
			}
			else if (opcao == 2) {
				System.out.println("Escolha o item a ser escrito: ");
				String dado = new Scanner(System.in).next();
				Item item = new Item(dado);
				if(lm.LX(t, item)){
					t.setEstado(g.vertices.get(g.vertices.indexOf(Grafo.ATIVA)));
				}
				g.estadoTransacoes();
				eventos();
			}
			else if (opcao == 3) {
				novaTransacao();
			}
			else if (opcao == 4) {
				System.out.print("Informe o id da transação que você deseja: ");
				String id = new Scanner(System.in).nextLine();
				String outroId = g.procurarTransacao(id).getId();

				if (g.transacaoExiste(outroId)) {
					Menu m = new Menu(g, g.procurarTransacao(outroId));
					m.eventos();
				}
				else {
					System.out.println("Transação desejada não existe");
				}
			}
			else {
				System.out.println("Opção inválida!");
			}
			
		}
		break;
		
		case "ATIVA":
		{
			System.out.println("\nEstado atual da transação " + t.getId() + ": ATIVA");

			System.out.println("\n(1) READ");
			System.out.println("(2) WRITE");
			System.out.println("(3) TR_Terminate");
			System.out.println("(4) TR_Rollback");
			System.out.println("(5) TR_Begin");
			System.out.println("(6) Mudar transação");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				System.out.println("Escolha o item a ser lido: ");
				String dado = new Scanner(System.in).next();
				Item item = new Item(dado);
				if(lm.LS(t, item)){
					t.setEstado(g.vertices.get(g.vertices.indexOf(Grafo.ATIVA)));
				}
				g.estadoTransacoes();
				eventos();
			}
			else if (opcao == 2) {
				System.out.println("Escolha o item a ser escrito: ");
				String dado = new Scanner(System.in).next();
				Item item = new Item(dado);
				if(lm.LX(t, item)){
					t.setEstado(g.vertices.get(g.vertices.indexOf(Grafo.ATIVA)));
				}
				g.estadoTransacoes();
				eventos();
			}
			else if (opcao == 3) {
				t.setEstado(g.vertices.get(g.vertices.indexOf(Grafo.PROCESSO_EFETIVACAO)));
				g.estadoTransacoes();
				eventos();
			}
			else if (opcao == 4) {
				t.setEstado(g.vertices.get(g.vertices.indexOf(Grafo.PROCESSO_CANCELAMENTO)));
				g.estadoTransacoes();
				eventos();
			}
			else if (opcao == 5) {
				this.novaTransacao();
			}
			else if (opcao == 6) {
				System.out.print("Informe o id da transação que você deseja: ");
				String id = new Scanner(System.in).nextLine();
				String outroId = g.procurarTransacao(id).getId();

				if (g.transacaoExiste(outroId)) {
					Menu m = new Menu(g, g.procurarTransacao(outroId));
					m.eventos();
				}
				else {
					System.out.println("Transação desejada não existe");
				}
			}
			else {
				System.out.println("Opção inválida!");
			}
			
		}
		break;
		
		case "PROCESSO_CANCELAMENTO":
		{
			System.out.println("\nEstado atual da transação " + t.getId() + ": PROCESSO_CANCELAMENTO");

			System.out.println("\n(1) TR_Finish");
			System.out.println("(2) TR_Begin");
			System.out.println("(3) Mudar transação");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				t.setEstado(g.vertices.get(g.vertices.indexOf(Grafo.TR_FINALIZADA)));
				System.out.println("\nTransação finalizada");
				g.estadoTransacoes();
				this.eventos();
			}
			else if (opcao == 2) {
				this.novaTransacao();
			}
			else if (opcao == 3) {
				System.out.print("Informe o id da transação que você deseja: ");
				String id = new Scanner(System.in).nextLine();
				String outroId = g.procurarTransacao(id).getId();

				if (g.transacaoExiste(outroId)) {
					Menu m = new Menu(g, g.procurarTransacao(outroId));
					m.eventos();
				}
				else {
					System.out.println("Transação desejada não existe");
				}
			}
			else {
				System.out.println("Opção inválida!");
			}

		}
		break;
		
		case "PROCESSO_EFETIVACAO":
		{			
			System.out.println("\nEstado atual da transação " + t.getId() + ": PROCESSO_EFETIVACAO");

			System.out.println("\n(1) TR_Rollback");
			System.out.println("(2) TR_Commit");
			System.out.println("(3) TR_Begin");
			System.out.println("(4) Mudar transação");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				t.setEstado(g.vertices.get(g.vertices.indexOf(Grafo.PROCESSO_CANCELAMENTO)));
				g.estadoTransacoes();
				this.eventos();
			}
			else if (opcao == 2) {
				t.setEstado(g.vertices.get(g.vertices.indexOf(Grafo.EFETIVADA)));
				g.estadoTransacoes();
				this.eventos();
			}
			else if (opcao == 3) {
				this.novaTransacao();
			}
			else if (opcao == 4) {
				System.out.print("Informe o id da transação que você deseja: ");
				String id = new Scanner(System.in).nextLine();
				String outroId = g.procurarTransacao(id).getId();

				if (g.transacaoExiste(outroId)) {
					Menu m = new Menu(g, g.procurarTransacao(outroId));
					m.eventos();
				}
				else {
					System.out.println("Transação desejada não existe");
				}
			}
			else {
				System.out.println("Opção inválida!");
			}

		}
		break;
		
		case "EFETIVADA":
		{	
			System.out.println("\nEstado atual da transação " + t.getId() + ": EFETIVADA");

			System.out.println("\n(1) TR_Finish");
			System.out.println("(2) TR_Begin");
			System.out.println("(3) Mudar transação");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				t.setEstado(g.vertices.get(g.vertices.indexOf(Grafo.TR_FINALIZADA)));
				System.out.println("\nTransação finalizada");
				g.estadoTransacoes();
				this.eventos();
			}
			else if (opcao == 2) {
				this.novaTransacao();
			}
			else if (opcao == 3) {
				System.out.print("Informe o id da transação que você deseja: ");
				String id = new Scanner(System.in).nextLine();
				String outroId = g.procurarTransacao(id).getId();

				if (g.transacaoExiste(outroId)) {
					Menu m = new Menu(g, g.procurarTransacao(outroId));
					m.eventos();
				}
				else {
					System.out.println("Transação desejada não existe");
				}
			}
			else {
				System.out.println("Opção inválida!");
			}

		}
		break;
		
		case "TR_FINALIZADA":
		{
			System.out.println("\nEstado atual da transação " + t.getId() + ": TR_FINALIZADA");
			
			System.out.println("\n(1) TR_Begin");
			System.out.println("(2) Mudar transação");
			System.out.println("(3) Sair");
			
			int opcao = new Scanner(System.in).nextInt();
			
			if (opcao == 1) {
				this.novaTransacao();
			}
			else if (opcao == 2) {
				System.out.print("Informe o id da transação que você deseja: ");
				String id = new Scanner(System.in).nextLine();
				String outroId = g.procurarTransacao(id).getId();

				if (g.transacaoExiste(outroId)) {
					Menu m = new Menu(g, g.procurarTransacao(outroId));
					m.eventos();
				}
				else {
					System.out.println("Transação desejada não existe");
				}
			}
			else if (opcao == 3) {
				System.exit(0);
			}
			else {
				System.out.println("Opção inválida!");
			}

		}
		
		}
		
	}
	
	public void novaTransacao() {
		
		System.out.print("Defina um id para essa transação: ");
		String novoId = new Scanner(System.in).nextLine();
		
		if (g.transacaoExiste(novoId)) {
			System.out.println("\nTransação já existe");		
		}
		else {
			TrManager.addTs();
			Transacao novaT = new Transacao(novoId,TrManager.getTs());
			g.criarTransacao(novaT);
			g.estadoTransacoes();

			Menu m = new Menu(g, novaT);
			m.eventos();
		}
		
	}
}

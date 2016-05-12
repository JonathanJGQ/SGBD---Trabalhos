package transacoes;

import java.util.Vector;

public class Grafo {
	
	private Vector<Integer> vertices;
	
	private Vector<Transacao> transacoes;

	public Grafo() {
		vertices = new Vector<Integer>();
		transacoes = new Vector<Transacao>();
	}
	
	public void criarTransacao(Transacao t) {
		transacoes.addElement(t);
		System.out.println("Transação adicionada ao grafo");
		transacoesAtivas();
	}
	
	public void adicionarVertice(int estado) {
		vertices.addElement(estado);
	}
	
	public void adicionarAresta() {
		
	}
		
	public void imprimir() {
		System.out.print("Grafo: ");
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i) + " -> ");
		}
	}
	
	public void transacoesAtivas() {
		System.out.print("Transações ativas: ");
		for (int i = 0; i < transacoes.size(); i++) {
			System.out.print(transacoes.elementAt(i) + ", ");
		}
	}
	
	public void estadoTransacoes() {
		for (int i = 0; i < transacoes.size(); i++) {
			System.out.println("Estado da transação " + transacoes.elementAt(i) + ": " + transacoes.get(i).getEstado());
		}
	}
}

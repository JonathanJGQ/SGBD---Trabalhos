package transacoes;

import java.util.Vector;

public class Grafo {
	
	static String TR_INICIADA = "TR_INICIADA";
	static String ATIVA = "ATIVA";
	static String PROCESSO_CANCELAMENTO = "PROCESSO_CANCELAMENTO";
	static String PROCESSO_EFETIVACAO = "PROCESSO_EFETIVACAO";
	static String EFETIVADA = "EFETIVADA";
	static String TR_FINALIZADA = "TR_FINALIZADA";
	
	public Vector<String> vertices;
	private Vector<Transacao> transacoes;

	public Grafo() {
		vertices = new Vector<String>();
		transacoes = new Vector<Transacao>();
		
		adicionarVertices();
	}
	
	private void adicionarVertices() {
		vertices.addElement(ATIVA);
		vertices.addElement(PROCESSO_CANCELAMENTO);
		vertices.addElement(PROCESSO_EFETIVACAO);
		vertices.addElement(EFETIVADA);
		vertices.addElement(TR_FINALIZADA);
	}
	
	public void criarTransacao(Transacao t) {
		if (!transacaoExiste(t.getId())) {
			transacoes.addElement(t);
			System.out.println("Transação id " + t.getId() + " adicionada ao grafo");
		}
		else {
			System.out.println("Transação com o mesmo id já existe");
		}
		
		transacoesAtivas();
	}
	
	public void transacoesAtivas() {
		System.out.print("Transações ativas: ");
		for (int i = 0; i < transacoes.size(); i++) {
			System.out.print(transacoes.get(i).getId() + ", ");
		}
	}
	
	public void estadoTransacoes() {
		System.out.println("\n");
		for (int i = 0; i < transacoes.size(); i++) {
			System.out.println("Estado da transação " + transacoes.get(i).getId() + ": " + transacoes.get(i).getEstado());
		}
	}
	
	public Transacao procurarTransacao(String id) {
		for (int i = 0; i < transacoes.size(); i++) {
			if (id.equals(transacoes.get(i).getId())) {
				return transacoes.get(i);
			}
		}
		return null;
	}
	
	public boolean transacaoExiste(String id) {
		for (int i = 0; i < transacoes.size(); i++) {
			if (id.equals(transacoes.get(i).getId())) {
				return true;
			}
		}
		return false;
	}
}

package transacoes;

public class Transacao {
	
	private String id;
	private String estado;
	
	public Transacao(String id) {
		this.id = id;
		setEstado(Grafo.TR_INICIADA);
		System.out.println("\nTransação com id " + getId() + " criada. Estado: " + getEstado());
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
}

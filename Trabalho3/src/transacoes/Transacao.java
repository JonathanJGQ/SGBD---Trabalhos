package transacoes;

public class Transacao {
	
	private String id;
	private String estado;
	private int ts;
	
	public Transacao(String id, int ts) {
		this.id = id;
		this.ts = ts;
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
	
	public int getTs(){
		return this.ts;
	}
}

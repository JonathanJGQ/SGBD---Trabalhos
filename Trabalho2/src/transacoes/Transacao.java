package transacoes;

public class Transacao {
	
	static int TR_INICIADA 		  	 = 1;
	static int ATIVA 				 = 2;
	static int PROCESSO_CANCELAMENTO = 3;
	static int PROCESSO_EFETIVACAO   = 4;
	static int EFETIVADA 			 = 5;
	static int TR_FINALIZADA 		 = 6;
	
	private int estado;
	
	public Transacao() {
		this.setEstado(TR_INICIADA);
		System.out.println("\nTransação criada. Estado: TR_INICIADA");
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public int getEstado() {
		return estado;
	}
	
}

package transacoes;

import java.util.ArrayList;

public class LockManager {
	
	LockTable lt = new LockTable();
	WaitQ wq = new WaitQ();

	//bloqueio de modo compartilhado
	public boolean LS(Transacao t, Item item){
		
		if(!wq.verificaEspera(t)){
			//se estiver na fila de espera...
			System.out.println("\nTransacao está na fila de espera");
			return false;
		}
		if(!lt.checarBloqueioLeitura(item)){
			//se o item está bloqueado exclusivamente...
			ArrayList<String> espera = new ArrayList<String>();
			espera.add(t.getId());
			espera.add(item.getInfo());
			espera.add("LS");
			wq.adicionarItem(espera);
			return false;
		}
		lt.adicionarBloqueio(t,item,"S");
		return true;
	}
	
	//bloqueio de modo exclusivo
	public boolean LX(Transacao t, Item item){
		if(!wq.verificaEspera(t)){
			//se estiver na fila de espera...
			System.out.println("\nTransacao " + t.getId() + " está na fila de espera!");
			return false;
		}
		if(!lt.checarBloqueioEscrita(t,item)){
			//se o item está bloqueado...
			ArrayList<String> espera = new ArrayList<String>();
			espera.add(t.getId());
			espera.add(item.getInfo());
			espera.add("LX");
			wq.adicionarItem(espera);
			return false;
		}
		lt.adicionarBloqueio(t,item,"X");
		return true;
	}
	
	//apaga o bloqueio
	public void U(Transacao t){
		lt.liberarTransacao(t);
	}

}

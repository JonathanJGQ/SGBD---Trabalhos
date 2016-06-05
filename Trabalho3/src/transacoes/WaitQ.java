package transacoes;

import java.util.ArrayList;

public class WaitQ {
	public static ArrayList<ArrayList> fila = new ArrayList<ArrayList>();
	public LockTable lt;
	
	//ELEMENTOS DE CADA NÓ: [TRANSAÇÃO,ITEM,TIPO_BLOQUEIO]
	
	public void adicionarItem(ArrayList espera){
		if(verificarDuplicata(espera)){
			fila.add(espera);
			System.out.println("\nTransacao " + espera.get(0).toString() + " adicionado a fila de espera!");
		}
	}
	
	private boolean verificarDuplicata(ArrayList espera){
		ArrayList aux;
		for(int i=0;i<fila.size();i++){
			aux = fila.get(i);
			if(aux.get(0).equals(espera.get(0)) && aux.get(1).equals(espera.get(1)) && aux.get(2).equals(espera.get(2))){
				return false;
			}
		}
		return true;
	}
	
	public boolean verificaEspera(Transacao t){
		ArrayList aux;
		for(int i=0;i<fila.size();i++){
			aux = fila.get(i);
			if(aux.get(0).equals(t.getId())){
				return false;
			}
		}
		return true;
	}
	
	public void checarFilaEspera(ArrayList transacao){
		ArrayList aux;
		for(int i=0;i<fila.size();i++){
			aux = fila.get(i);
			if(aux.get(1).equals(transacao.get(1))){
				Grafo.atualizaTransacao(aux.get(0).toString());
				Transacao t_aux = new Transacao(aux.get(0).toString(),0);
				Item i_aux = new Item(aux.get(1).toString());
				lt = new LockTable();
				lt.adicionarBloqueio(t_aux, i_aux, aux.get(2).toString());
				fila.remove(aux);
				return;
			}
		}
	}
}

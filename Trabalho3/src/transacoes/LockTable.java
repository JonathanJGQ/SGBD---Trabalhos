package transacoes;

import java.util.ArrayList;
import java.util.List;

public class LockTable {
	public static ArrayList<ArrayList> lockTable = new ArrayList<ArrayList>();
	
	//ELEMENTOS DE CADA NÓ: [TRANSAÇÃO,ITEM,TIPO_BLOQUEIO]
	
	public boolean checarBloqueioLeitura(Item item){
		boolean achou = true;
		ArrayList aux;
		for(int i=0;i<lockTable.size();i++){
			aux = lockTable.get(i);
			if(item.getInfo().equals(aux.get(1).toString()) && aux.get(2).toString().equals("X")){
				System.out.println("Item bloqueado (exclusivo)!");
				achou = false;
			}
		}
		return achou;
	}
	
	public boolean checarBloqueioEscrita(Item item){
		boolean achou = true;
		ArrayList aux;
		for(int i=0;i<lockTable.size();i++){
			aux = lockTable.get(i);
			if(item.getInfo().equals(aux.get(1).toString())){
				System.out.println("Item bloqueado!");
				achou = false;
			}
		}
		return achou;
	}
	
	public void adicionarBloqueio(Transacao t, Item item, String tipo){
		ArrayList bloqueio = new ArrayList();
		if(validarDuplicata(t,item,tipo)){
			bloqueio.add(t.getId());
			bloqueio.add(item.getInfo());
			bloqueio.add(tipo);
			lockTable.add(bloqueio);
			System.out.println("Item " + item.getInfo() + " foi bloqueado(" + tipo + ")");
		}
	}
	
	private boolean validarDuplicata(Transacao t,Item item, String tipo){
		ArrayList aux;
		for(int i=0;i<lockTable.size();i++){
			aux = lockTable.get(i);
			if(aux.get(0).equals(t.getId()) && aux.get(1).equals(item.getInfo()) && aux.get(2).equals(tipo)){
				System.out.println("Item já está bloqueado");
				return false;
			}
		}
		return true;
	}
}

package transacoes;

import java.util.ArrayList;

public class WaitQ {
	public static ArrayList<ArrayList> fila = new ArrayList<ArrayList>();
	
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
			if(aux.get(0).equals(espera.get(0)) && aux.get(1).equals(espera.get(1))){
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
}

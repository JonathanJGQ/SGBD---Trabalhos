package arvore;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Arvore {
	
	private String[] raiz;
	private String[] noAtual;
	private String[] resultado;
	private String nomeBanco = "dados.txt";
	private String nomeIndice = "indice.txt";
	
	public Arvore(){
		String linha;
		try{
			FileReader reader = new FileReader(nomeIndice);
			BufferedReader leitor = new BufferedReader(reader);
			linha = leitor.readLine();
			raiz = linha.split(Pattern.quote(","));
			leitor.close();
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Erro ao ler arquivo!","Erro",0);
		}
	}
	
	public void percorrer(int ano){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		noAtual = raiz;
		String linhaAtual;
		
		try{
			while(!noAtual[2].equals("EDAD")){
				ids = separarRids(noAtual[1]);
				if( ano <= Integer.parseInt(noAtual[0]) || ids.size() == 1){
					linhaAtual = Files.readAllLines(Paths.get(nomeIndice)).get(ids.get(0) - 1);
					noAtual = linhaAtual.split(Pattern.quote(","));
				}
				else{
					linhaAtual = Files.readAllLines(Paths.get(nomeIndice)).get(ids.get(1) - 1);
					noAtual = linhaAtual.split(Pattern.quote(","));
				}
			}
			if(ano == Integer.parseInt(noAtual[0])){
				ids = separarRids(noAtual[1]);
				for(int i=0;i<ids.size();i++){
					linhaAtual = Files.readAllLines(Paths.get(nomeBanco)).get(ids.get(i) - 1);
					linhaAtual = linhaAtual.replace(",", " ");
					System.out.println(linhaAtual);
				}
			}
			else{
				System.out.println("Colheita não encontrada!");
			}
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	private ArrayList separarRids(String rids){
		ArrayList<Integer> retorno = new ArrayList<Integer>();
		String idAtual = "";
		for(int i=0;i<rids.length();i++){
			char c = rids.charAt(i);
			if(c == 'R' && !idAtual.equals("")){
				retorno.add(Integer.parseInt(idAtual));
				idAtual = "";
			}
			else{
				if(c != 'R'){
					idAtual = idAtual + c;
				}
			}
		}
		retorno.add(Integer.parseInt(idAtual));
		return retorno;
	}
}

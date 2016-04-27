package arvore;

import java.io.File;
import java.util.Formatter;

import javax.swing.JOptionPane;

public class CriarDados {
	
	private String nomeBanco = "dados.txt";
	private String nomeIndice = "indice.txt";
	private String newLine = System.getProperty("line.separator");
	private String dados = "V1,P1,Merlot,2006,Brasil" + newLine +
							"V2,P3,Chardonnay,2008,Franca" + newLine +
							"V3,P3,Syrah,2009,Franca" + newLine +
							"V4,P4,Malbec,2010,Franca" + newLine +
							"V5,P5,Bonarda,2012,Italia" + newLine +
							"V6,P6,Chenin Blanc,2013,Argentina";
	
	public void criarArquivos(){
		criarBanco();
		criarIndice();
	}
	
	public void apagarArquivos(){
		apagarBanco();
		apagarIndice();
	}
	
	private void criarBanco(){
		
		try{
			Formatter saida = new Formatter(nomeBanco);
		    saida.format(dados);
		    saida.close();
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Arquivo de dados não pode ser gerado!","Erro",0);
		}
	}
	
	private void criarIndice(){
		try{
			Formatter saida = new Formatter(nomeIndice);
		    saida.format(indices());
		    saida.close();
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Arquivo de indice não pode ser gerado!","Erro",0);
		}
	}
	
	private void apagarBanco(){
		try{
			File file = new File(nomeBanco);  
			file.delete();
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	private void apagarIndice(){
		try{
			File file = new File(nomeIndice);  
			file.delete();
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	private String indices(){
		String indice = "";
		
		indice = "2009,R2R3,EIND" + newLine +
				"2008,R4R5,EIND" + newLine +
				"2010,R5R6,EIND" + newLine +
				"2007,R7R8,EIND" + newLine +
				"2009,R9R10,EIND" + newLine +
				"2012,R11R12,EIND" + newLine +
				"2006,R1,EDAD" + newLine +
				"2008,R2,EDAD" + newLine +
				"2009,R3,EDAD" + newLine +
				"2010,R4,EDAD" + newLine +
				"2012,R5,EDAD" + newLine +
				"2013,R6,EDAD";
		
		return indice;
	}
}

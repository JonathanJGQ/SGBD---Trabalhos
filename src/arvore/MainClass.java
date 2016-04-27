package arvore;

public class MainClass {
	public static void main(String[] args){
		Menu menu = new Menu();
		CriarDados criarDados = new CriarDados();
		
		criarDados.criarArquivos();
		menu.inicio();
		criarDados.apagarArquivos();
	}
}

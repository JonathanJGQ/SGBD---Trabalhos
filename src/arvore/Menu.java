package arvore;

import java.util.Scanner;

public class Menu {
	
	private Arvore arvore;
	
	public void inicio(){
		
		int ano;
		
		System.out.println("Digite o ano da colheita: ");
		Scanner scan = new Scanner(System.in);
		ano = scan.nextInt();
		arvore = new Arvore();
		arvore.percorrer(ano);
	}
}

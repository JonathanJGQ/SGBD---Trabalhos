package transacoes;

public class TrManager {
	private static int timestamp = 0;
	
	public static int getTs(){
		return timestamp;
	}
	
	public static void addTs(){
		timestamp++;
	}
}

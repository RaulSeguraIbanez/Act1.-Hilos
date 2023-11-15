package hilos;

public class CFilPrincipal {
	public static void main(String[] args) {
		
		CFil proceso1 = new CFil("proceso1");
		
		proceso1.seTemporizador(2000);
		
		System.out.println("Comienza el proceso padre");
		
		proceso1.start();
		
		System.out.println("Termina el proceso padre");
	}
}

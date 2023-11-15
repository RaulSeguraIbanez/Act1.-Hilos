package hilos;

public class CFil extends Thread {
	private int temporizador = 0;
	private String nombre = "";
	
	public void seTemporizador(int temporizacion) {
		this.temporizador = temporizacion;
	}
	
	public String getNombre() {
		String nombre = this.nombre;
		return nombre;
	}
	
	public CFil(String nombre) {
		super(nombre);
	}
	
	public void run() {
		System.out.println(getName() + " Ha iniciado");

        try {
        	
            Thread.sleep(temporizador);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " Ha terminado");
	}
}

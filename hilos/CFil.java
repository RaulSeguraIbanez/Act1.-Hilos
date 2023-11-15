package hilos;

public class CFil extends Thread {
	private int temporizador = 0;
	private String nombre = "";
	
	public void setter(int temporizacion) {
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
		
	}
}

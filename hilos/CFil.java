package hilos;

public class CFil extends Thread {
    private String nombre;
    private int temporizacion;

    // Constructor
    public CFil(String nombre) {
        this.nombre = nombre;
        this.temporizacion = 1000;
    }

    // Getter y setter para temporización
    public int getTemporizacion() {
        return temporizacion;
    }

    public void setTemporizacion(int temporizacion) {
        this.temporizacion = temporizacion;
    }

    // Método run
    public void run() {
        try {
            // Lógica específica del proceso hijo
            Thread.sleep(temporizacion);
            System.out.println(nombre + " ha terminado.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Ejercicio 1.1: Temporización para que el proceso hijo termine antes que el padre
    public void ejercicio1_1() {
        setTemporizacion(500);
        start();
        System.out.println("Proceso padre ha terminado.");
    }

    // Ejercicio 1.2: Temporización para que el proceso hijo termine después que el padre
    public void ejercicio1_2() {
        start();
        // Lógica del proceso padre
        System.out.println("Proceso padre ha terminado.");
    }

    // Ejercicio 1.3: Asegurar que el proceso padre siempre termine después del hijo
    public void ejercicio1_3() {
        start();
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Proceso padre ha terminado después del hijo.");
    }
}


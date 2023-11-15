package hilos;

import java.util.Scanner;

public class CFilPrincipal {
    private static CFil hijo = new CFil("Hijo");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//funcionalidad del menu
        mostrarMenu();
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                hijo.ejercicio1_1();
                break;
            case 2:
                hijo.ejercicio1_2();
                break;
            case 3:
                hijo.ejercicio1_3();
                break;
            case 4:
                iniciarMultiplesProcesos();
                break;
            default:
                System.out.println("Opción no válida. Saliendo del programa.");
        }

        scanner.close();
    }
//menu
    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Proceso hijo termina antes que el padre");
        System.out.println("2. Proceso hijo termina después que el padre");
        System.out.println("3. Proceso padre siempre termina después del hijo");
        System.out.println("4. Iniciar múltiples procesos hijos con diferentes temporizaciones");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
// aqui esta el ejercicio 4
    private static void iniciarMultiplesProcesos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de procesos hijos:");
        int numProcesos = scanner.nextInt();

        if (numProcesos > 10) {
            System.out.println("Número de procesos hijos exageradamente grande. Limitado a 10.");
            numProcesos = 10;
        }

        CFil[] hijos = new CFil[numProcesos];

        for (int i = 0; i < numProcesos; i++) {
            hijos[i] = new CFil("Hijo" + i);
            hijos[i].setTemporizacion(1000 / (i + 1));
            hijos[i].start();
        }

        for (int i = 0; i < numProcesos; i++) {
            try {
                hijos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Proceso padre ha terminado.\n");
    }
}
package org.example;

import org.example.ContenedorInteligente;

public class RobotClasificador implements Runnable {
    private final ContenedorInteligente contenedor;
    private final int numBotellas;

    public RobotClasificador(ContenedorInteligente contenedor, int numBotellas) {
        this.contenedor = contenedor;
        this.numBotellas = numBotellas;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= numBotellas; i++) {
                contenedor.depositar();
                Thread.sleep(100);  // Tiempo que tarda en clasificar
                System.out.println("[ROBOT] Clasificando botella " + i + "...");
            }
            System.out.println("[ROBOT] Turno finalizado. Todas las botellas procesadas.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

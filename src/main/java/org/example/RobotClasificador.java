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
                Thread.sleep(100);  // Tiempo de clasificación
                System.out.println("Robot clasificó botella " + i);
            }
            System.out.println("Robot terminó.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

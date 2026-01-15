package org.example;
import java.util.concurrent.Semaphore;

public class DronRecolector implements Runnable {
    private final ContenedorInteligente contenedor;
    private final int botellasPorViaje;

    public DronRecolector(ContenedorInteligente contenedor, int botellasPorViaje) {
        this.contenedor = contenedor;
        this.botellasPorViaje = botellasPorViaje;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (contenedor.disponibles.availablePermits() >= botellasPorViaje) {
                    contenedor.recoger(botellasPorViaje);
                    Thread.sleep(5000);
                    System.out.println("Dron completó viaje.");
                } else {
                    System.out.println("Dron esperando suficientes botellas...");
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Dron interrumpido.");
        }
    }
}

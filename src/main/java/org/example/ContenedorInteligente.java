package org.example;

import java.util.concurrent.Semaphore;

public class ContenedorInteligente {
    private final Semaphore libres;
    public final Semaphore disponibles;
    private final int capacidad;

    public ContenedorInteligente(int capacidad) {
        this.capacidad = capacidad;
        this.libres = new Semaphore(capacidad);
        this.disponibles = new Semaphore(0);
    }

    public void depositar() throws InterruptedException {
        libres.acquire();
        disponibles.release();
        System.out.println("Botella depositada. Disponibles: " + disponibles.availablePermits());
    }

    public void recoger(int cantidad) throws InterruptedException {
        disponibles.acquire(cantidad);
        libres.release(cantidad);
        System.out.println("Recogidas " + cantidad + " botellas. Disponibles: " + disponibles.availablePermits());
    }
}

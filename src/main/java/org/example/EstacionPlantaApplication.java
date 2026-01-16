package org.example;
// SIN @SpringBootApplication

public class EstacionPlantaApplication {
    public static void main(String[] args) throws InterruptedException {
        ContenedorInteligente contenedor = new ContenedorInteligente(10);
        Thread robot = new Thread(new RobotClasificador(contenedor, 20));
        Thread dron = new Thread(new DronRecolector(contenedor, 4));

        robot.start();
        dron.start();
        robot.join();
        dron.interrupt();
        System.out.println("PGV => Fin de la simulación");
    }
}


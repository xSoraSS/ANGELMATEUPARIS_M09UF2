package Jugador;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cursa {

    public static void main(String[] args){
        ScheduledExecutorService schExService = Executors.newScheduledThreadPool(2);
        // Crea objecte Runnable.
        Jugador jugadorA = new Jugador("A");
        Jugador jugadorB = new Jugador("B");

        //empiezo a correr
        AddPoints addPointsA = new AddPoints(jugadorA);
        AddPoints addPointsB = new AddPoints(jugadorB);

        //Monitorizar
        Monitorizar monitorizarA = new Monitorizar(jugadorA);
        Monitorizar monitorizarB = new Monitorizar(jugadorB);

        // Programa Fil, s'inicia als 2 segons i després es va executant cada 3 segons
        schExService.scheduleWithFixedDelay( addPointsA,1, 1, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay( addPointsB,1, 2, TimeUnit.SECONDS);

        schExService.scheduleWithFixedDelay( monitorizarA,2, 1, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay( monitorizarB,2, 1, TimeUnit.SECONDS);

        try {
            // Espera per acabar 10 segons
            schExService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // shutdown .
        schExService.shutdownNow();

    }
}

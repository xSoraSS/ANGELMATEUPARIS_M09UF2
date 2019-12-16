package Cargol;

import java.awt.image.CropImageFilter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CursaCargols {

    public static void main(final String... args) throws InterruptedException, ExecutionException {
        //mostrem hora actual abans d'execució

        // Crea un pool de 2 fils
        final ScheduledExecutorService schExService = Executors.newScheduledThreadPool(2);
        // Crea objecte Runnable.
        Cargol turbo = new Cargol("Turbo");
        Cargol bala = new Cargol("Bala");
        final Runnable ob = turbo;
        final Runnable ob2 = bala;
        // Programa Fil, s'inicia als 2 segons i després es va executant cada 3 segons
        schExService.scheduleWithFixedDelay(ob, 2, 3, TimeUnit.SECONDS);

        schExService.scheduleWithFixedDelay(ob2, 2, 5, TimeUnit.SECONDS);
        // Espera per acabar 10 segons
        schExService.awaitTermination(10, TimeUnit.SECONDS);
        // shutdown .
        schExService.shutdownNow();
        System.out.println("Turbo Metres Total: " + turbo.getMetres() + "\nBala Metres Total: " + bala.getMetres());
    }
}

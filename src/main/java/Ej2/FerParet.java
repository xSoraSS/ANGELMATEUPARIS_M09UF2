package Ej2;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class FerParet {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        int numMaons = 10, ti, te;
        int numPaletes = 5;

        //instanciem els paletes
        List<Paleta> listaPaletas = new ArrayList<>();

        //comencem a contar el temps
        ti = (int) System.currentTimeMillis();
        //Donem nom als paletes i els posem a fer fer la paret
        for (int i=0;i<numPaletes;i++) {
            Paleta Obrero = new Paleta("Paleta"+i);
            listaPaletas.add(Obrero);
        }

        executor.invokeAll(listaPaletas);
        //Han acabat i agafem el temps final
        te = (int) System.currentTimeMillis();

        executor.shutdown();

        System.out.println("Han trigat: " + (te - ti)/1000 + " segons");
    }
}
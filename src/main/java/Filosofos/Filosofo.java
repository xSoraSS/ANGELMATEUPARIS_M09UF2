package Filosofos;

import CursaRelleus.Testigo;

public class Filosofo extends Thread {

    Cubierto cubierto;

    public Filosofo(Cubierto c, String nom) {
        super(nom);
        cubierto = c;
    }

    @Override
    public void run() {
        for(;;) {

            cubierto.Agafa();
            System.out.println(getName() + " Comiendo.");
            try {
                Thread.sleep((long) (Math.random()*800)+200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cubierto.Deixa();

            try {
                System.out.println(getName() + " No comiendo");
                Thread.sleep((long) (Math.random()*1000)+500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
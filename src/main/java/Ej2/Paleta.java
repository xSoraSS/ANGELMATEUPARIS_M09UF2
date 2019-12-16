package Ej2;

import java.util.concurrent.Callable;

public class Paleta implements Callable<Integer>{
    private String Nom;

    public Paleta(String nom) {
        Nom = nom;

    }

    public int posaMaons(int maons) {
        //Temps que triga a col·locar els maons entre 1 i 4 segons per cada maó
        System.out.println(Nom + " posant maons...");
        try {
            Thread.sleep((long) ((Math.random()*300)+100)*maons );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Nom + " ha acabat.");
        return maons;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    @Override
    public Integer call() throws Exception {
        return posaMaons(20);
    }
}
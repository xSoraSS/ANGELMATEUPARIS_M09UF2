package Ej1;

public class AlumneP {

    private String Nom;

    public AlumneP(String nom) {
        Nom = nom;
    }

    public int Examinar() {
        //Temps que triga a fer l'examen
        try {
            Thread.sleep((long) (Math.random()*1000)+500 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Nota de l'examen
        int nota = (int) (Math.random()*10);
        return nota;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}
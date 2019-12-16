package Ej1;

import java.util.ArrayList;
import java.util.List;


public class Examen {

    public static void main(String[] args) {
        int numAlumnes = 10, ti, te;
        String Modul = "Alumne";

        List<AlumneP> llistaAlumnes = new ArrayList<AlumneP>();

        for (int i=0;i<numAlumnes;i++) {
            AlumneP A_m9 = new AlumneP(Modul+"-"+i);
            llistaAlumnes.add(A_m9);
        }

        int[] notes = new int[llistaAlumnes.size()];

        ti = (int) System.currentTimeMillis();
        for (int i = 0; i < llistaAlumnes.size(); i++) {
            notes[i] = llistaAlumnes.get(i).Examinar();
            System.out.println(llistaAlumnes.get(i).getNom() + ": " + notes[i]);
        }

        te = (int) System.currentTimeMillis();

        System.out.println("Han trigat: " + (te - ti)/1000 + " segons");
    }
}
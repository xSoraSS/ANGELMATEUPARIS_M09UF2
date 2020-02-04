package Inditex;

public class Ensamblador implements Runnable  {
        private String Nom;
        private Cistell cistell_manigues, cistell_cossos;

        public Ensamblador(Cistell cistell_manigues, Cistell cistell_cossos, String nom) {
            this.cistell_manigues = cistell_manigues;
            this.cistell_cossos = cistell_cossos;
            Nom = nom;
        }

        public Ensamblador() {
            super();
        }

    @Override
    public void run() {
        cistell_manigues.agafaManiga(1);
        cistell_cossos.agafaCos(1);
        System.out.println("Manigues que queden = " + cistell_manigues.getNumeroManigues() + "\nCossos que queden = " + cistell_cossos.getNumeroCossos());
    }
}


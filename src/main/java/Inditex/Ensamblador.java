package Inditex;

public class Ensamblador implements Runnable  {
        private String nom;
        private Cistell cistell_manigues, cistell_cossos;
        private int cantidadActual;

        public Ensamblador(Cistell cistell_manigues, Cistell cistell_cossos, String nom) {
            this.cistell_manigues = cistell_manigues;
            this.cistell_cossos = cistell_cossos;
            this.nom = nom;
            this.cantidadActual = 0;
        }

        public Ensamblador() {
            super();
        }

    @Override
    public void run() {
        for (;;){
            cistell_cossos.agafar();
            System.out.println(nom + " agafa " + cistell_cossos.tipo);
            cistell_manigues.agafar();
            System.out.println(nom + " agafa " + cistell_manigues.tipo);
            cistell_manigues.agafar();
            System.out.println(nom + " agafa " + cistell_manigues.tipo);
            int tmp = (int) ((Math.random() * 4000) + 2000);
            System.out.println(nom + " esta cosint ");
            try {
                Thread.sleep(tmp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cantidadActual++;
            System.out.println(nom + " ha finalitzat, hi ha  " + cantidadActual + " peça de roba");
        }
    }
}


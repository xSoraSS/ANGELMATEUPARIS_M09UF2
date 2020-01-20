package CursaRelleus;

public class Atleta extends Thread {

    String equipo;
    Testigo testigo;

    public Atleta(Testigo t, String nom, String equipo) {
        super(nom);
        this.equipo = equipo;
        testigo = t;
    }

    @Override
    public void run() {
        for(;;) {
            //Agafa el comandament
            testigo.Agafa();
            System.out.println(getName() + " ara porto el testimoni.");
            System.out.println("Sóc de " + equipo + "\n");
            //Mira la tele
            try {
                Thread.sleep((long) (Math.random()*800)+200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Deixa el comandament
            testigo.Deixa();
            //Descansa de tanta tele
            try {
                System.out.println(getName() + " ja no porto el testimoni");
                Thread.sleep((long) (Math.random()*1000)+500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
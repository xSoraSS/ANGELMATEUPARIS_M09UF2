package Inditex;

public class Cosidor extends  Thread {

    private String pieza;
    private Cistell cistell;
    private int tmp;


    public Cosidor( Cistell cistell, String pieza) {
        this.pieza = pieza;
        this.cistell = cistell;
        tmp=0;
    }

    @Override
    public void run() {
        for (;;){
            if (cistell != null) cistell.cosir();
            tmp = (int) ((Math.random() * 4000) + 4000);
            System.out.println(pieza + ": s'esta cosint...");
            try {
                Thread.sleep(tmp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (cistell != null) cistell.deixar();
            System.out.println(pieza + " deixa el cistell...hay " + cistell.cantidadActual + ".");
        }
    }
}
package CursaRelleus;

public class Testigo {
    private boolean lliure;

    public Testigo() {
        lliure = true;
    }

    public synchronized void Agafa() {
        try {
            while(!lliure) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lliure = false;
        notifyAll();
    }

    public synchronized void Deixa() {
        lliure = true;
        notifyAll();
    }
}
package Inditex;

public class Cistell {

    boolean coser = false;
    int cantidadMaxima,  cantidadActual;
    String tipo;

    public Cistell(int cantMax, String tipo) {
        this.cantidadMaxima = cantMax;
        this.cantidadActual =0;
        this.tipo = tipo;
    }

    public synchronized void cosir() {
        try {
            while (coser) wait();
            coser = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deixar() {
        try {
            while (cantidadActual == cantidadMaxima) wait();
            cantidadActual++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
    }

    public synchronized void agafar () {
        try {
            while (cantidadActual == 0 ) wait();
            cantidadActual--;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

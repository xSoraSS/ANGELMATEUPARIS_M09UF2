package Jugador;

public class Monitorizar implements Runnable {
    Jugador jugador1;



    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }
    @Override
    public void run() {
        System.out.println("El jugador: "+jugador1.getNom() +" lleva "+jugador1.getPunts()+".");
    }

    public Monitorizar(Jugador jugador1) {
        this.jugador1 = jugador1;
    }
}

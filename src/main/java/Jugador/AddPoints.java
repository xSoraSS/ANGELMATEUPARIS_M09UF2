package Jugador;

public class AddPoints implements Runnable {

    Jugador jugador1;



    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public AddPoints(Jugador jugador1) {
        this.jugador1 = jugador1;
    }
    @Override
    public void run() {
        jugador1.setPunts((int) Math.floor(Math.random()*10));
    }
}

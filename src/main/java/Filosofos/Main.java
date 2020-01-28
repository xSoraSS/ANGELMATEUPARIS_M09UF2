package Filosofos;

public class Main {

    public static void main(String[] args) {

        Cubierto cubierto = new Cubierto();
        Cubierto cubierto2 = new Cubierto();

        Filosofo filosofo1 = new Filosofo(cubierto,  "Kidd Keo");
        Filosofo filosofo2 = new Filosofo(cubierto, "Dudu El Burlao");
        Filosofo filosofo3 = new Filosofo(cubierto, "Bad Gyal");
        Filosofo filosofo4 = new Filosofo(cubierto, "Paulo Coelho - 2020");


        filosofo1.start();
        filosofo2.start();
        filosofo3.start();
        filosofo4.start();
    }
}

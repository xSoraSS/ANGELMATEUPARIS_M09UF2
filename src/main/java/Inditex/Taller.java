package Inditex;

public class Taller {

    public static void main(String[] args) {
        Cistell cistell_manigues = new Cistell(8, "maniga");
        Cistell cistell_cossos = new Cistell(5, "cos");
        Cosidor cosidor_manigues = new Cosidor(cistell_manigues, "Maniga");
        Cosidor cosidor_cossos = new Cosidor(cistell_cossos, "Cos");
        Ensamblador ensamblador = new Ensamblador(cistell_manigues, cistell_cossos, "Treballador");

        cosidor_cossos.start();
        cosidor_manigues.start();
        ensamblador.run();
    }
}

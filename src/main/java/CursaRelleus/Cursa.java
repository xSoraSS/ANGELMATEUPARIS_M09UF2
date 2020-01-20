package CursaRelleus;

public class Cursa {

    public static void main(String[] args) {
        Testigo testigo = new Testigo();
        //Equipo 1
        Atleta angel = new Atleta(testigo,"Angel", "Equipo 1");
        Atleta judit = new Atleta(testigo,"Judit", "Equipo 1");
        Atleta sora = new Atleta(testigo,"Sora", "Equipo 1");

        //Equipo 2
        Atleta eric = new Atleta(testigo,"Eric", "Equipo 2");
        Atleta david = new Atleta(testigo,"David", "Equipo 2");
        Atleta cesar = new Atleta(testigo,"Cesar", "Equipo 2");

        angel.start();
        judit.start();
        sora.start();
        eric.start();
        david.start();
        cesar.start();
    }
}

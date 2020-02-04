package Inditex;

public class Cosidor {

    private String pieza;
    private Cistell cistell;


    public Cosidor(Cistell c, String pieza) {
        cistell = c;
        this.pieza = pieza;
    }

    public Cosidor() {
        super();
    }

    public void start(){
        if (pieza.equals("Maniga") && !cistell.cistellManiguesPle){
            for (int i = 1; i < cistell.numero_max+1; i++) {
                cistell.setNumeroManigues(i);
//                System.out.println("Mangas Actuales "+cistell.getNumeroManigues());
            }
            if (cistell.getNumeroManigues() == cistell.numero_max){
                cistell.setCistellManiguesPle(true);
            }

        }else if(pieza.equals("Cos") && !cistell.cistellCossosPle){
            for (int i = 1; i < cistell.numero_max+1; i++) {
                cistell.setNumeroCossos(i);
//                System.out.println("Cuerpos Actuales "+cistell.getNumeroCossos());
            }
            if (cistell.getNumeroCossos() == cistell.numero_max){
                cistell.setCistellCossosPle(true);
            }
        }
    }
}

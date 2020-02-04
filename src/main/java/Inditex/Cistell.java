package Inditex;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cistell {

    int numero_max, numeroManigues, numeroCossos;
    boolean cistellManiguesPle, cistellCossosPle, hiHaManigues, hiHaCossos;

    public Cistell(int numMax) {
        this.numero_max = numMax;
        hiHaCossos = false;
        hiHaManigues = false;
        cistellCossosPle = false;
        cistellManiguesPle = false;
    }

    public int getNumeroManigues() {
        return numeroManigues;
    }

    public void setNumeroManigues(int numeroManigues) {
        this.numeroManigues = numeroManigues;
    }

    public int getNumeroCossos() {
        return numeroCossos;
    }

    public void setNumeroCossos(int numeroCossos) {
        this.numeroCossos = numeroCossos;
    }

    public boolean isCistellManiguesPle() {
        return cistellManiguesPle;
    }

    public void setCistellManiguesPle(boolean cistellManiguesPle) {
        this.cistellManiguesPle = cistellManiguesPle;
    }

    public boolean isCistellCossosPle() {
        return cistellCossosPle;
    }

    public void setCistellCossosPle(boolean cistellCossosPle) {
        this.cistellCossosPle = cistellCossosPle;
    }

    public synchronized int agafaManiga(int i) {
        System.out.println("vull agafar");
        try {
            while(cistellManiguesPle || !hiHaManigues) wait();
            cistellManiguesPle = true;
            this.numeroManigues = this.numeroManigues - i;
            System.out.println("Agafo "+i+" galetes");
            if(this.numeroManigues <= 0) hiHaManigues = false;
            cistellManiguesPle = false;
            notifyAll();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return numeroManigues;
    }

    public synchronized int agafaCos(int i) {
        System.out.println("vull agafar");
        try {
            while(cistellCossosPle || !hiHaCossos) wait();
            cistellCossosPle = true;
            this.numeroCossos = this.numeroCossos - i;
            System.out.println("Agafo "+i+" galetes");
            if(this.numeroCossos <= 0) hiHaCossos = false;
            cistellCossosPle = false;
            notifyAll();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return numeroCossos;
    }

    public static void main(String[] args) throws InterruptedException {
        Ensamblador ensamblador = new Ensamblador();
        // Crea un pool de 2 fils
        final ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);
        // Crea objecte Runnable.


        // Programa Fil, s'inicia als 2 segons i després es va executant cada 3 segons
        schExService.scheduleWithFixedDelay(ensamblador., 2, 3, TimeUnit.SECONDS);

        // Espera per acabar 35 segons
        schExService.awaitTermination(30, TimeUnit.SECONDS);

        // shutdown .
        schExService.shutdownNow();
        System.out.println("Completat");

    }
}

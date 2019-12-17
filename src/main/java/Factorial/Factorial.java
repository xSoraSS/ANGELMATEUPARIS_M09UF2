package Factorial;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Factorial extends RecursiveTask {
    int n;

    public Factorial(int n){
        this.n = n;
    }

    private Double factSeq(){
        System.out.println("Secuencial");
        double temp = n;
        for (int i = 1; i < n ; i++) {
            temp *= i;
        }
        return temp;
    }

    private Double factRec() {
        System.out.println("Recursiva");
        Factorial task = new Factorial(n-1);
        task.fork();
        return n * (double) task.join();
    }

    @Override
    protected Double compute(){
        if(n < 3){
            return factSeq();
        }else{
            return factRec();
        }
    }

    public static void main(String[] args) {
        ForkJoinPool exec = new ForkJoinPool();
        Factorial factorial = new Factorial(170);
        exec.invoke(factorial);
        double result = (double) factorial.join();
        System.out.println(result);
    }
}

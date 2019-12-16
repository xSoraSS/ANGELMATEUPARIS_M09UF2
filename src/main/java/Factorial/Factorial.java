package Factorial;

import java.util.concurrent.RecursiveTask;

public class Factorial extends RecursiveTask {
    int n;

    public Factorial(int n){
        this.n = n;
    }

    @Override
    protected Double compute(){
        if(n < 100){
            //Recursivo

        }else{
            //Sequencial
        }
    }
    public static void main(String[] args) {

    }
}

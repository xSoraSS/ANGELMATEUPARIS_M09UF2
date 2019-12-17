package Fibonacci;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    private int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if(n < 5){
            return fibonacciSeq();
        }else{
            return fibonacciRec();
        }
    }

    private Integer fibonacciRec() {
        Fibonacci f1 = new Fibonacci(n-1);
        Fibonacci f2 = new Fibonacci(n-2);
        f1.fork();
        f2.fork();
        return f1.join() + f2.join();
    }

    private Integer fibonacciSeq() {
        int prev1 = 0, prev2 = 1;
        for (int i = 0; i < n; i++) {
            int savePrev1 = prev1;
            prev1 = prev2;
            prev2 += savePrev1;
        }
        return prev1;
    }

    public static void main(String[] args) {
        ForkJoinPool exec = new ForkJoinPool();
        Fibonacci fibonacci = new Fibonacci(6);
        exec.invoke(fibonacci);
        int result = fibonacci.join();
        System.out.println(result);
    }
}

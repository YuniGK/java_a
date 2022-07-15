package chr07;

public class Fibonacci {
    int[] value;
    int number;

    public Fibonacci(int number){
        this.number = number;
        value = new int[number];
    }

    public int FibonacciRecur(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        return FibonacciRecur(n-1)+FibonacciRecur(n-2);
    }

    public int FibonacciIter(int n){
        int ppre = 0;
        int pre = 1;
        int current = 0;

        if(n == 0) return 0;
        if(n == 1) return 1;

        for (int i = 2; i <= n; i++) {
            current = ppre + pre;
            ppre = pre;
            pre = current;
        }

        return current;
    }

    public int FibonacciMem(int n){
        value[0] = 0;
        value[1] = 1;

        if(n == 0) return value[0];
        if(n == 1) return value[1];

        int i;

        for (i = 2; i <= n; i++) {
            value[i] = value[i-1]+value[i-2];
        }
        return value[i-1];
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci(100);

        int result = fib.FibonacciRecur(10);
        System.out.println(result);

        result = fib.FibonacciIter(10);
        System.out.println(result);

        result = fib.FibonacciMem(10);
        System.out.println(result);
    }    
}
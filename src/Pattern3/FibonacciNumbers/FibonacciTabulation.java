package Pattern3.FibonacciNumbers;

class FibonacciTabulation {

    public int CalculateFibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int n1 = 0, n2 = 1, oldN1;
        for (int i = 2; i <= n; i++) {
            oldN1 = n1;
            n1 = n2;
            n2 += oldN1;
        }
        return n2;
    }

    public static void main(String[] args) {
        FibonacciTabulation fib = new FibonacciTabulation();
        System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
    }
}
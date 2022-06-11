package Pattern3.FibonacciNumbers;

class FibonacciMemoization {

    public int CalculateFibonacci(int n) {
        if (n < 2) {
            return n;
        }
        Integer[] dp = new Integer[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (dp[n] == null) {
            dp[n] = CalculateFibonacci(n - 1) + CalculateFibonacci(n - 2);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciMemoization fib = new FibonacciMemoization();
        System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
    }
}
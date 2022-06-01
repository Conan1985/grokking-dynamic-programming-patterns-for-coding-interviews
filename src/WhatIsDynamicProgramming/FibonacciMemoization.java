package WhatIsDynamicProgramming;

class FibonacciMemoization {

    public int CalculateFibonacci(int n) {
        if (n < 2)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        return calculateFibonacciRecursive(dp, n);
    }

    private int calculateFibonacciRecursive(int[] dp, int n) {
        if (n < 2)
            return n;
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = calculateFibonacciRecursive(dp, n - 1) + calculateFibonacciRecursive(dp, n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciMemoization fib = new FibonacciMemoization();
        System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
    }
}
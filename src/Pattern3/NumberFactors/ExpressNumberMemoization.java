package Pattern3.NumberFactors;

class ExpressNumberMemoization {

    public int CountWays(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        Integer[] dp = new Integer[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        if (dp[n] == null) {
            dp[n] = CountWays(n - 1) + CountWays(n - 3) + CountWays(n - 4);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ExpressNumberMemoization en = new ExpressNumberMemoization();
        System.out.println(en.CountWays(4));
        System.out.println(en.CountWays(5));
        System.out.println(en.CountWays(6));
    }
}
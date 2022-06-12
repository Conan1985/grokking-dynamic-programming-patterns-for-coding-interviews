package Pattern3.Staircase;

class StaircaseMemoization {

    public int CountWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        Integer[] dp = new Integer[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        if (dp[n] == null) {
            int step1Ways = CountWays(n - 1);
            int step2Ways = CountWays(n - 2);
            int step3Ways = CountWays(n - 3);
            dp[n] = step1Ways + step2Ways + step3Ways;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        StaircaseMemoization sc = new StaircaseMemoization();
        System.out.println(sc.CountWays(3));
        System.out.println(sc.CountWays(4));
        System.out.println(sc.CountWays(5));
    }
}

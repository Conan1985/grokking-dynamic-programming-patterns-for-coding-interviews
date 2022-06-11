package Pattern2.CoinChange;

class CoinChangeTabulation {

    public int countChange(int[] denominations, int total) {
        if (total == 0) {
            return 1;
        }
        if (denominations.length == 0) {
            return 0;
        }
        int n = denominations.length;
        int[][] dp = new int[n][total + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= total; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (denominations[i] <= j) {
                    dp[i][j] = dp[i][j] + dp[i][j - denominations[i]];
                }
            }
        }
        return dp[n - 1][total];
    }

    public static void main(String[] args) {
        CoinChangeTabulation cc = new CoinChangeTabulation();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
    }
}

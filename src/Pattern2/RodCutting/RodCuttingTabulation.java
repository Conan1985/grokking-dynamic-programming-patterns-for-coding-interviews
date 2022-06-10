package Pattern2.RodCutting;

public class RodCuttingTabulation {
    public int solveRodCutting(int[] lengths, int[] prices, int n) {
        if (n == 0) {
            return 0;
        }
        int l = lengths.length;
        Integer[][] dp = new Integer[l][n + 1];
        for (int i = 0; i < l; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < l; i++) {
            for (int j = 1; j <= n; j++) {
                int profit1 = 0, profit2 = 0;
                if (lengths[i] <= j) {
                    profit1 = prices[i] + dp[i][j - lengths[i]];
                }
                if (i > 0) {
                    profit2 = dp[i - 1][j];
                }
                dp[i][j] = Math.max(profit1, profit2);
            }
        }
        return dp[l - 1][n];
    }

    public static void main(String[] args) {
        RodCuttingTabulation rc = new RodCuttingTabulation();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }
}

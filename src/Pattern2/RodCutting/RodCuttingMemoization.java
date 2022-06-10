package Pattern2.RodCutting;

public class RodCuttingMemoization {
    public int solveRodCutting(int[] lengths, int[] prices, int n) {
        int l = lengths.length;
        Integer[][] dp = new Integer[l][n + 1];
        return solveRodCuttingRecursive(dp, lengths, prices, n, 0);
    }

    private int solveRodCuttingRecursive(Integer[][] dp, int[] lengths, int[] prices, int n, int currentIndex) {
        if (n == 0 || currentIndex >= lengths.length) {
            return 0;
        }
        if (dp[currentIndex][n] == null) {
            int profit1 = 0;
            if (lengths[currentIndex] <= n) {
                profit1 = prices[currentIndex] + solveRodCuttingRecursive(dp, lengths, prices, n - lengths[currentIndex], currentIndex);
            }
            int profit2 = solveRodCuttingRecursive(dp, lengths, prices, n, currentIndex + 1);
            dp[currentIndex][n] = Math.max(profit1, profit2);
        }
        return dp[currentIndex][n];
    }

    public static void main(String[] args) {
        RodCuttingMemoization rc = new RodCuttingMemoization();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }
}

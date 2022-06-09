package Pattern2.UnboundedKnapsack;

class KnapsackTabulation {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (capacity == 0 || profits.length <= 0 || profits.length != weights.length) {
            return 0;
        }
        int n = profits.length;
        Integer[][] dp = new Integer[n][capacity + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {
                int profit1 = 0, profit2 = 0;
                if (weights[i] <= j) {
                    profit1 = profits[i] + dp[i][j - weights[i]];
                }
                if (i > 0) {
                    profit2 = dp[i - 1][j];
                }
                dp[i][j] = Math.max(profit1, profit2);
            }
        }
        return dp[n - 1][capacity];
    }

    public static void main(String[] args) {
        KnapsackTabulation ks = new KnapsackTabulation();
        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        System.out.println(ks.solveKnapsack(profits, weights, 8));
        System.out.println(ks.solveKnapsack(profits, weights, 6));
    }
}
package Pattern1.Knapsack;

class KnapsackTabulation {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        if (capacity <= 0 || profits.length <= 0 || profits.length != weights.length) {
            return 0;
        }
        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= capacity; j++) {
            if (weights[0] <= capacity) {
                dp[0][j] = profits[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= capacity; j++) {
                int profit1 = 0;
                if (weights[0] <= capacity) {
                    profit1 = profits[i] + dp[i-1][capacity - weights[j]];
                }
                int profit2 = dp[i-1][j];
                dp[i][j] = Math.max(profit1, profit2);
            }
        }
        return dp[n-1][capacity];
    }

    public static void main(String[] args) {
        KnapsackBruteForce ks = new KnapsackBruteForce();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
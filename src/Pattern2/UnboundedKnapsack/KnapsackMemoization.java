package Pattern2.UnboundedKnapsack;

class KnapsackMemoization {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        Integer[][] dp = new Integer[n][capacity + 1];
        return knapsackRecursive(dp, profits, weights, capacity, 0);
    }

    private int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity == 0 || profits.length <= 0 || profits.length != weights.length || currentIndex >= profits.length) {
            return 0;
        }
        if (dp[currentIndex][capacity] == null) {
            int profit1 = 0;
            if (weights[currentIndex] <= capacity) {
                profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights, capacity - weights[currentIndex], currentIndex);
            }
            int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
            dp[currentIndex][capacity] = Math.max(profit1, profit2);
        }
        return dp[currentIndex][capacity];
    }

    public static void main(String[] args) {
        KnapsackMemoization ks = new KnapsackMemoization();
        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        System.out.println(ks.solveKnapsack(profits, weights, 8));
        System.out.println(ks.solveKnapsack(profits, weights, 6));
    }
}
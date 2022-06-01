package Pattern1.Knapsack;

class KnapsackMemoization {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        if (capacity <= 0 || profits.length <= 0 || profits.length != weights.length) {
            return 0;
        }
        int n = profits.length;
        Integer[][] dp = new Integer[n][capacity + 1];
        return solveKnapsackRecursive(dp, profits, weights, capacity, 0);
    }

    private int solveKnapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        if (currentIndex >= profits.length) {
            return 0;
        };
        if (dp[currentIndex][capacity] != null) {
            return dp[currentIndex][capacity];
        }
        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + solveKnapsackRecursive(dp, profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }
        int profit2 = solveKnapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        KnapsackMemoization ks = new KnapsackMemoization();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
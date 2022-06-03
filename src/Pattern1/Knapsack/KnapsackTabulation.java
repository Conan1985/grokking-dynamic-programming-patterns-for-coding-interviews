package Pattern1.Knapsack;

class KnapsackTabulation {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        if (capacity <= 0 || profits.length <= 0 || profits.length != weights.length) {
            return 0;
        }
        int n = profits.length;
        int[] dp = new int[capacity + 1];
        for (int j = 0; j <= capacity; j++) {
            if (weights[0] <= j) {
                dp[j] = profits[0];
            }
        }
        for (int i = 1; i < n; i++) {
            int[] oldDP = new int[capacity + 1];
            System.arraycopy(dp, 0, oldDP, 0, capacity + 1);
            for (int j = 1; j <= capacity; j++) {
                int profit1 = 0;
                if (weights[i] <= j) {
                    profit1 = profits[i] + oldDP[j - weights[i]];
                }
                int profit2 = oldDP[j];
                dp[j] = Math.max(profit1, profit2);
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        KnapsackTabulation ks = new KnapsackTabulation();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
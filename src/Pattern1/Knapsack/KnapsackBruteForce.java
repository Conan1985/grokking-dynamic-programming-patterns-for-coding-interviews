package Pattern1.Knapsack;

class KnapsackBruteForce {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        return solveKnapsackRecursive(profits, weights, capacity, 0);
    }

    private int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex >= profits.length || profits.length != weights.length) {
            return 0;
        }
        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + solveKnapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }
        int profit2 = solveKnapsackRecursive(profits, weights, capacity, currentIndex + 1);
        return Math.max(profit1, profit2);
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
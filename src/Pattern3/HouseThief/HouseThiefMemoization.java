package Pattern3.HouseThief;

class HouseThiefMemoization {

    public int findMaxSteal(int[] wealth) {
        int n = wealth.length;
        Integer[] dp = new Integer[n];
        return findMaxStealRecursive(dp, wealth, wealth.length - 1);
    }

    private int findMaxStealRecursive(Integer[] dp, int[] wealth, int currentIndex) {
        if (currentIndex == 0) {
            return wealth[0];
        }
        if (currentIndex == 1) {
            return Math.max(wealth[0], wealth[1]);
        }
        if (dp[currentIndex] == null) {
            dp[currentIndex] = Math.max(findMaxStealRecursive(dp, wealth, currentIndex - 1), findMaxStealRecursive(dp, wealth, currentIndex - 2) + wealth[currentIndex]);
        }
        return dp[currentIndex];
    }

    public static void main(String[] args) {
        HouseThiefMemoization ht = new HouseThiefMemoization();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));
    }
}

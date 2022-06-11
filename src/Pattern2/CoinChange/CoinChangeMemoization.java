package Pattern2.CoinChange;

class CoinChangeMemoization {

    public int countChange(int[] denominations, int total) {
        Integer[][] dp = new Integer[denominations.length][total + 1];
        return countChangeRecursive(dp, denominations, total, 0);
    }

    private int countChangeRecursive(Integer[][] dp, int[] denominations, int total, int currentIndex) {
        if (total == 0) {
            return 1;
        }
        if (currentIndex >= denominations.length) {
            return 0;
        }
        if (dp[currentIndex][total] == null) {
            int sum1 = 0;
            if (denominations[currentIndex] <= total) {
                sum1 = countChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex);
            }
            int sum2 = countChangeRecursive(dp, denominations, total, currentIndex + 1);
            dp[currentIndex][total] = sum1 + sum2;
        }
        return dp[currentIndex][total];
    }

    public static void main(String[] args) {
        CoinChangeMemoization cc = new CoinChangeMemoization();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
    }
}

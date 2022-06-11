package Pattern2.MinimumCoinChange;

class CoinChangeMemoization {

    public int countChange(int[] denominations, int total) {
        int n = denominations.length;
        Integer[][] dp = new Integer[n][total + 1];
        int count = countChangeRecursive(dp, denominations, total, 0);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int countChangeRecursive(Integer[][] dp, int[] denominations, int total, int currentIndex ) {
        if (total == 0) {
            return 0;
        }
        if (denominations.length == 0 || currentIndex >= denominations.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[currentIndex][total] == null) {
            int count1 = Integer.MAX_VALUE;
            if (denominations[currentIndex] <= total) {
                int res = countChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex);
                count1 = res != Integer.MAX_VALUE ? res + 1 : count1;
            }
            int count2 = countChangeRecursive(dp, denominations, total, currentIndex + 1);
            dp[currentIndex][total] = Math.min(count1, count2);
        }
        return dp[currentIndex][total];
    }

    public static void main(String[] args) {
        CoinChangeMemoization cc = new CoinChangeMemoization();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChange(denominations, 7));
    }
}
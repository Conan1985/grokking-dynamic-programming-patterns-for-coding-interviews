package Pattern2.MinimumCoinChange;

class CoinChangeTabulation {

    public int countChange(int[] denominations, int total) {
        if (total == 0) {
            return 0;
        }
        if (denominations.length == 0) {
            return -1;
        }
        int n = denominations.length;
        int[][] dp = new int[n][total + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= total; j++) {
                int count1 = Integer.MAX_VALUE;
                int count2 = Integer.MAX_VALUE;
                if (denominations[i] <= j) {
                    int res = dp[i][j - denominations[i]];
                    count1 = res != Integer.MAX_VALUE ? res + 1 : count1;
                }
                if (i > 0) {
                    count2 = dp[i - 1][j];
                }
                dp[i][j] = Math.min(count1, count2);
            }
        }
        return dp[n - 1][total] == Integer.MAX_VALUE ? -1 : dp[n - 1][total];
    }

    public static void main(String[] args) {
        CoinChangeTabulation cc = new CoinChangeTabulation();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChange(denominations, 7));
    }
}
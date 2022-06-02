package Pattern1.EqualSubsetSumPartition;

class PartitionSetTabulation {

    public boolean canPartition(int[] num) {
        int sum = 0;
        for (int j : num) {
            sum += j;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = num.length;
        sum /= 2;
        boolean [][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int s = 0; s <= sum; s++) {
            dp[0][s] = num[0] == s;
        }
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (num[i] <= s) {
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }
        return dp[n - 1][sum];
    }

    public static void main(String[] args) {
        PartitionSetTabulation ps = new PartitionSetTabulation();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
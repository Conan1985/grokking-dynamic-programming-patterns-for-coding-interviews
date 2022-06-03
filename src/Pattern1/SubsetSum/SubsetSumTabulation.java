package Pattern1.SubsetSum;

public class SubsetSumTabulation {
    public boolean canPartition(int[] num, int sum) {
        if (num.length == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        int n = num.length;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int s = 1; s <= sum; s++) {
            dp[s] = num[0] == s;
        }
        for (int i = 1; i < n; i++) {
            boolean[] oldDP = new boolean[sum + 1];
            System.arraycopy(dp, 0, oldDP, 0, sum + 1);
            for (int s = 1; s <= sum; s++) {
                if (oldDP[s]) {
                    dp[s] = oldDP[s];
                } else if (num[i] <= s) {
                    dp[s] = oldDP[s - num[i]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        SubsetSumTabulation ss = new SubsetSumTabulation();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }

}

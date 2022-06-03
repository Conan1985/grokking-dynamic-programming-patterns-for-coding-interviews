package Pattern1.SubsetSum;

public class SubsetSumMemoization {
    public boolean canPartition(int[] num, int sum) {
        if (num.length == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        int n = num.length;
        Boolean[][] dp = new Boolean[n][sum + 1];
        return canPartitionRecursive(dp, num, sum, 0);
    }

    private boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {
        if (sum == 0) {
            return true;
        }
        if (num.length == 0 || currentIndex >= num.length) {
            return false;
        }
        if (dp[currentIndex][sum] == null) {
            if (num[currentIndex] <= sum) {
                if (canPartitionRecursive(dp, num, sum - num[currentIndex], currentIndex + 1)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }
            dp[currentIndex][sum] = canPartitionRecursive(dp, num, sum, currentIndex + 1);
        }
        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        SubsetSumMemoization ss = new SubsetSumMemoization();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }

}

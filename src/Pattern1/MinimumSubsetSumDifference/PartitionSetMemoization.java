package Pattern1.MinimumSubsetSumDifference;

class PartitionSetMemoization {

    public int canPartition(int[] num) {
        // TODO: Write your code here
        int n = num.length;
        int sum = 0;
        for (int k : num) {
            sum += k;
        }
        Integer[][] dp = new Integer[n][sum + 1];
        return canPartitionRecursive(dp, num, 0, 0, 0);
    }

    private int canPartitionRecursive(Integer[][] dp, int[] num, int sum1, int sum2, int currentIndex) {
        if (currentIndex == num.length) {
            return Math.abs(sum1 - sum2);
        }
        if (dp[currentIndex][sum1] == null) {
            int diff1 = canPartitionRecursive(dp, num, sum1 + num[currentIndex], sum2, currentIndex + 1);
            int diff2 = canPartitionRecursive(dp, num, sum1, sum2 + num[currentIndex], currentIndex + 1);
            dp[currentIndex][sum1] = Math.min(diff1, diff2);
        }
        return dp[currentIndex][sum1];
    }

    public static void main(String[] args) {
        PartitionSetMemoization ps = new PartitionSetMemoization();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
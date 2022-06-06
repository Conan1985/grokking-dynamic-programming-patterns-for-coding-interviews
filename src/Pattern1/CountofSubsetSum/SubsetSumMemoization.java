package Pattern1.CountofSubsetSum;

public class SubsetSumMemoization {
    public int countSubsets(int[] num, int sum) {
        int n = num.length;
        Integer[][] dp = new Integer[n][sum + 1];
        return counterSubsetsRecursive(dp, num, sum, 0);
    }

    private int counterSubsetsRecursive(Integer[][] dp, int[] num, int sum, int currentIndex) {
        if (sum == 0) {
            return 1;
        }
        if (num.length == 0 || currentIndex >= num.length) {
            return 0;
        }
        if (dp[currentIndex][sum] == null) {
            int sum1 = 0;
            if (num[currentIndex] <= sum ) {
                sum1 = counterSubsetsRecursive(dp, num, sum - num[currentIndex], currentIndex + 1);
            }
            int sum2 = counterSubsetsRecursive(dp, num, sum, currentIndex + 1);
            dp[currentIndex][sum] = sum1 + sum2;
        }
        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        SubsetSumMemoization ss = new SubsetSumMemoization();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}

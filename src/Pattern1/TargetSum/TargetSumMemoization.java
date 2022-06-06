package Pattern1.TargetSum;

class TargetSumMemoization {

    public int findTargetSubsets(int[] num, int s) {
        // TODO: Write your code here
        int n = num.length;
        int sum = 0;
        for (int k : num) {
            sum += k;
        }
        if (sum < s || (sum + s ) % 2 != 0) {
            return 0;
        }

        sum = (sum + s) / 2;
        Integer[][] dp = new Integer[n][sum + 1];
        return findTargetSubsetsRecursive(dp, num, sum, 0);
    }

    private int findTargetSubsetsRecursive(Integer[][] dp, int[] num, int sum, int currentIndex) {
        if (sum == 0) {
            return 1;
        }
        if (num.length == 0 || currentIndex >= num.length) {
            return 0;
        }
        if (dp[currentIndex][sum] == null) {
            dp[currentIndex][sum] = findTargetSubsetsRecursive(dp, num, sum, currentIndex + 1);
            if (num[currentIndex] <= sum) {
                dp[currentIndex][sum] += findTargetSubsetsRecursive(dp, num, sum - num[currentIndex], currentIndex + 1);
            }
        }
        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        TargetSumMemoization ts = new TargetSumMemoization();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}
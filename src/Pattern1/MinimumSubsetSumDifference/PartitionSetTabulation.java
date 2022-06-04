package Pattern1.MinimumSubsetSumDifference;

class PartitionSetTabulation {

    public int canPartition(int[] num) {
        // TODO: Write your code here
        if (num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int n = num.length;
        int sum = 0;
        for (int k : num) {
            sum += k;
        }
        boolean[][] dp = new boolean [n][sum/2 + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int s1 = 0; s1 <= sum/2; s1++) {
            dp[0][s1] = num[0] == s1;
        }
        for (int i = 1; i < n; i++) {
            for (int s1 = 1; s1 <= sum/2; s1++) {
                if (dp[i - 1][s1]) {
                    dp[i][s1] = dp[i - 1][s1];
                } else if (num[i] < s1) {
                    dp[i][s1] = dp[i - 1][s1 - num[i]];
                }
            }
        }
        int sum1 = 0;
        for (int s1 = sum/2; s1 >= 0; s1--) {
            if (dp[n - 1][s1]) {
                sum1 = s1;
                break;
            }
        }
        return Math.abs(2 * sum1 - sum);
    }

    public static void main(String[] args) {
        PartitionSetTabulation ps = new PartitionSetTabulation();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
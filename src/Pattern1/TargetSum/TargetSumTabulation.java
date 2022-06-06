package Pattern1.TargetSum;

class TargetSumTabulation {

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
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int j = 1; j <= sum; j++) {
            dp[j] = num[0] == j ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (num[i] <= j) {
                    dp[j] += dp[j - num[i]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        TargetSumTabulation ts = new TargetSumTabulation();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}
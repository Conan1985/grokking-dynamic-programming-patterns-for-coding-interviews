package Pattern1.CountofSubsetSum;

public class SubsetSumTabulation {
    public int countSubsets(int[] num, int sum) {
        int n = num.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int s = 1; s <= sum; s++) {
            dp[s] = num[0] == s ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            int[] oldDP = new int[sum + 1];
            System.arraycopy(dp, 0, oldDP, 0, sum + 1);
            for (int s = 1; s <= sum; s++) {
                dp[s] = oldDP[s];
                if (num[i] <= s) {
                    dp[s] += oldDP[s - num[i]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        SubsetSumTabulation ss = new SubsetSumTabulation();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}

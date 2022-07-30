package Pattern5.LongestCommonSubsequence;

public class LCSTabulation {
    public int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        int maxLength = 0;
        for (int i1 = 0; i1 < s1.length(); i1++) {
            for (int i2 = 0; i2 < s2.length(); i2++) {
                if (s1.charAt(i1) == s2.charAt(i2)) {
                    if (i1 == 0 || i2 == 0) {
                        dp[i1][i2] = 1;
                    } else {
                        dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                    }
                } else {
                    if (i1 == 0 || i2 == 0) {
                        dp[i1][i2] = 0;
                    } else {
                        dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
                    }
                }
                maxLength = Math.max(maxLength, dp[i1][i2]);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LCSTabulation lcs = new LCSTabulation();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));
    }
}

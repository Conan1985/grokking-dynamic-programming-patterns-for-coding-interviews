package Pattern5.LongestRepeatingSubsequence;

class LRSTabulation {

    public int findLRSLength(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        int maxLen = 0;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= str.length(); j++) {
                if (i != j && str.charAt(i - 1) == str.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int c1 = dp[i - 1][j];
                    int c2 = dp[i][j - 1];
                    dp[i][j] = Math.max(c1, c2);
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LRSTabulation lrs = new LRSTabulation();
        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength("aabdbcec"));
        System.out.println(lrs.findLRSLength("fmff"));
    }
}
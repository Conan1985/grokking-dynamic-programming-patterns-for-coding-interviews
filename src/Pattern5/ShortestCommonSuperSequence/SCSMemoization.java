package Pattern5.ShortestCommonSuperSequence;

class SCSMemoization {

    public int findSCSLength(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return findSCSLengthRecursive(dp, s1, s2, 0, 0);
    }

    private int findSCSLengthRecursive(Integer[][] dp, String s1, String s2, int i1, int i2) {
        if (i1 == s1.length()) {
            return s2.length() - i2;
        }
        if (i2 == s2.length()) {
            return s1.length() - i1;
        }
        if (dp[i1][i2] == null) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                dp[i1][i2] = 1 + findSCSLengthRecursive(dp, s1, s2, i1 + 1, i2 + 1);
            } else {
                int c1 = 1 + findSCSLengthRecursive(dp, s1, s2, i1 + 1, i2);
                int c2 = 1 + findSCSLengthRecursive(dp, s1, s2, i1, i2 + 1);
                dp[i1][i2] = Math.min(c1, c2);
            }
        }
        return dp[i1][i2];
    }

    public static void main(String[] args) {
        SCSMemoization scs = new SCSMemoization();
        System.out.println(scs.findSCSLength("abcf", "bdcf"));
        System.out.println(scs.findSCSLength("dynamic", "programming"));
    }
}


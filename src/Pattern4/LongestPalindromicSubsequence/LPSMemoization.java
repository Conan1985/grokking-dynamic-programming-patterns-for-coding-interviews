package Pattern4.LongestPalindromicSubsequence;

class LPSMemoization {

    public int findLPSLength(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return 1;
        }
        if (startIndex > endIndex) {
            return 0;
        }
        if (dp[startIndex][endIndex] == null) {
            if (st.charAt(startIndex) == st.charAt(endIndex)) {
                dp[startIndex][endIndex] = 2 + findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1);
            } else {
                dp[startIndex][endIndex] = Math.max(findLPSLengthRecursive(dp, st, startIndex + 1, endIndex), findLPSLengthRecursive(dp, st, startIndex, endIndex - 1));
            }
        }
        return dp[startIndex][endIndex];
    }

    public static void main(String[] args) {
        LPSMemoization lps = new LPSMemoization();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
package Pattern4.LongestPalindromicSubstring;

class LPSMemoization {

    public int findLPSLength(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return 1;
        }
        if (dp[startIndex][endIndex] == null) {
            if (st.charAt(startIndex) == st.charAt(endIndex)) {
                int remainLength = endIndex - startIndex - 1;
                if (remainLength == findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1)) {
                    dp[startIndex][endIndex] = remainLength + 2;
                    return dp[startIndex][endIndex];
                }
            }
            int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex);
            int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1);
            dp[startIndex][endIndex] = Math.max(c1, c2);
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
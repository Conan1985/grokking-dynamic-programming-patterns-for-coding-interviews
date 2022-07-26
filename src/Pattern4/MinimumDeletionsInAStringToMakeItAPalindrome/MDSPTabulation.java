package Pattern4.MinimumDeletionsInAStringToMakeItAPalindrome;

public class MDSPTabulation {
    public int findMinimumDeletions(String st) {
        return st.length() - findLongestSubSequence(st);
    }

    private int findLongestSubSequence(String st) {
        int[][] dp = new int[st.length()][st.length()];
        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = 1;
        }
        int maxLength = 1;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = dp[startIndex + 1][endIndex - 1] + 2;
                } else {
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
                maxLength = Math.max(maxLength, dp[startIndex][endIndex]);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        MDSPTabulation mdsp = new MDSPTabulation();
        System.out.println(mdsp.findMinimumDeletions("abdbca"));
        System.out.println(mdsp.findMinimumDeletions("cddpd"));
        System.out.println(mdsp.findMinimumDeletions("pqr"));
    }
}

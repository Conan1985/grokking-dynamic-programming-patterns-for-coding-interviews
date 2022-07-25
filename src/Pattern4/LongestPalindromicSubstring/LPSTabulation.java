package Pattern4.LongestPalindromicSubstring;

class LPSTabulation {

    public int findLPSLength(String st) {
        boolean[][] dp = new boolean[st.length()][st.length()];
        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = true;
        }
        int maxLength = 1;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    if (startIndex + 1 == endIndex || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                    }
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LPSTabulation lps = new LPSTabulation();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
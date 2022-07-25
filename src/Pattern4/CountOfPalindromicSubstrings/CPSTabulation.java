package Pattern4.CountOfPalindromicSubstrings;

class CPSTabulation {

    public int findCPS(String st) {
        boolean[][] dp = new boolean[st.length()][st.length()];
        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = true;
        }
        int count = st.length();
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    if (startIndex + 1 == endIndex || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CPSTabulation cps = new CPSTabulation();
        System.out.println(cps.findCPS("abdbca"));
        System.out.println(cps.findCPS("cdpdd"));
        System.out.println(cps.findCPS("pqr"));
    }
}

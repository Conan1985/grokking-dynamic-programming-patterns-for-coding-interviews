package Pattern4.PalindromicPartitioning;

class MPPTabulation {

    public int findMPPCuts(String st) {
        boolean[][] dpPalindrome = new boolean[st.length()][st.length()];
        for (int i = 0; i < st.length(); i++) {
            dpPalindrome[i][i] = true;
        }
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) != st.charAt(endIndex)) {
                    dpPalindrome[startIndex][endIndex] = false;
                } else if (startIndex + 1 == endIndex || dpPalindrome[startIndex + 1][endIndex - 1]) {
                    dpPalindrome[startIndex][endIndex] = true;
                }
            }
        }
        int[] dpMinCuts = new int[st.length()];
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            int minCuts = st.length();
            for (int endIndex = st.length() - 1; endIndex >= startIndex; endIndex--) {
                if (dpPalindrome[startIndex][endIndex]) {
                    minCuts = endIndex == st.length() - 1 ? 0 : Math.min(minCuts, 1 + dpMinCuts[endIndex + 1]);
                }
            }
            dpMinCuts[startIndex] = minCuts;
        }
        return dpMinCuts[0];
    }

    public static void main(String[] args) {
        MPPTabulation mpp = new MPPTabulation();
        System.out.println(mpp.findMPPCuts("abdbca"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
    }
}

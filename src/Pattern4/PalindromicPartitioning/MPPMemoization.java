package Pattern4.PalindromicPartitioning;

class MPPMemoization {

    public int findMPPCuts(String st) {
        Integer[][] dpMinCuts = new Integer[st.length()][st.length()];
        Boolean[][] dpPalindrome = new Boolean[st.length()][st.length()];
        return findMPPCutsRecursive(dpMinCuts, dpPalindrome, st, 0, st.length() - 1);
    }

    private int findMPPCutsRecursive(Integer[][] dpMinCuts, Boolean[][] dpPalindrome, String st, int startIndex, int endIndex) {
        if (startIndex > endIndex || isPalindrome(dpPalindrome, st, startIndex, endIndex)) {
            return 0;
        }
        if (dpMinCuts[startIndex][endIndex] == null) {
            int minCuts = endIndex - startIndex;
            for (int i = startIndex; i <= endIndex; i++) {
                if (isPalindrome(dpPalindrome, st, startIndex, i)) {
                    minCuts = Math.min(minCuts, 1 + findMPPCutsRecursive(dpMinCuts, dpPalindrome, st, i + 1, endIndex));
                }
            }
            dpMinCuts[startIndex][endIndex] = minCuts;
        }
        return dpMinCuts[startIndex][endIndex];
    }

    private boolean isPalindrome(Boolean[][] dpPalindrome, String st, int startIndex, int endIndex) {
        if (dpPalindrome[startIndex][endIndex] == null) {
            dpPalindrome[startIndex][endIndex] = true;
            int startInside = startIndex, endInside = endIndex;
            while (startInside <= endInside) {
                if (st.charAt(startInside++) != st.charAt(endInside--)) {
                    dpPalindrome[startIndex][endIndex] = false;
                    break;
                }
                if (startInside <= endInside && dpPalindrome[startInside][endInside] != null) {
                    dpPalindrome[startIndex][endIndex] = dpPalindrome[startInside][endInside];
                    break;
                }
            }
        }
        return dpPalindrome[startIndex][endIndex];
    }

    public static void main(String[] args) {
        MPPMemoization mpp = new MPPMemoization();
        System.out.println(mpp.findMPPCuts("abdbca"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
    }
}

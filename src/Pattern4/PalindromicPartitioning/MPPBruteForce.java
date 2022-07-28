package Pattern4.PalindromicPartitioning;

class MPPBruteForce {

    public int findMPPCuts(String st) {
        return findMPPCutsRecursive(st, 0, st.length() - 1);
    }

    private int findMPPCutsRecursive(String st, int startIndex, int endIndex) {
        if (startIndex > endIndex || isPalindrome(st, startIndex, endIndex)) {
            return 0;
        }
        int minCuts = endIndex - startIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            if (isPalindrome(st, startIndex, i)) {
                minCuts = Math.min(minCuts, 1 + findMPPCutsRecursive(st, i + 1, endIndex));
            }
        }
        return minCuts;
    }

    private boolean isPalindrome(String st, int startIndex, int endIndex) {
        int startInside = startIndex, endInside = endIndex;
        while (startInside <= endInside) {
            if (st.charAt(startInside++) != st.charAt(endInside--)) {
                return false;
            }
            if (isPalindrome(st, startInside, endInside)) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MPPBruteForce mpp = new MPPBruteForce();
        System.out.println(mpp.findMPPCuts("abdbca"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
    }
}

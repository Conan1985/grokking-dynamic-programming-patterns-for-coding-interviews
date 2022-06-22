package Pattern4.LongestPalindromicSubsequence;

class LPSBruteForce {

    public int findLPSLength(String st) {
        return findLPSLengthRecursive(st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return 1;
        }
        if (startIndex > endIndex) {
            return 0;
        }
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
            return 2 + findLPSLengthRecursive(st, startIndex + 1, endIndex - 1);
        } else {
            return Math.max(findLPSLengthRecursive(st, startIndex + 1, endIndex), findLPSLengthRecursive(st, startIndex, endIndex - 1));
        }
    }

    public static void main(String[] args) {
        LPSBruteForce lps = new LPSBruteForce();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
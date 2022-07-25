package Pattern4.LongestPalindromicSubstring;

class LPSBruteForce {

    public int findLPSLength(String st) {
        return findLPSLengthRecursive(st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return 1;
        }
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
            int remainLength = endIndex - startIndex - 1;
            if (remainLength == findLPSLengthRecursive(st, startIndex + 1, endIndex - 1)) {
                return remainLength + 2;
            }
        }
        int c1 = findLPSLengthRecursive(st, startIndex + 1, endIndex);
        int c2 = findLPSLengthRecursive(st, startIndex, endIndex - 1);
        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        LPSBruteForce lps = new LPSBruteForce();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
package Pattern5.LongestRepeatingSubsequence;

class LRSMemoization {

    public int findLRSLength(String str) {
        return findLRSLengthRecursive(str, 0, 0);
    }

    private int findLRSLengthRecursive(String str, int i1, int i2) {
        if (i1 == str.length() || i2 == str.length()) {
            return 0;
        }
        if (i1 != i2 && str.charAt(i1) == str.charAt(i2)) {
            return 1 + findLRSLengthRecursive(str, i1 + 1, i2 + 1);
        }
        int c1 = findLRSLengthRecursive(str, i1 + 1, i2);
        int c2 = findLRSLengthRecursive(str, i1, i2 + 1);
        return Math.max(c1, c2);
    }


    public static void main(String[] args) {
        LRSMemoization lrs = new LRSMemoization();
        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength("aabdbcec"));
        System.out.println(lrs.findLRSLength("fmff"));
    }
}
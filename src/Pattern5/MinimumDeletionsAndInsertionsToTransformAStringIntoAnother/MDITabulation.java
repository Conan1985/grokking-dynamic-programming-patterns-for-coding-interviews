package Pattern5.MinimumDeletionsAndInsertionsToTransformAStringIntoAnother;

public class MDITabulation {
    public void findMDI(String s1, String s2) {
        int c1 = findLCSLength(s1, s2);
        System.out.println("Minimum deletions needed: " + (s1.length() - c1));
        System.out.println("Minimum insertions needed: " + (s2.length() - c1));
    }

    private int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        int maxLength = 0;
        for (int i1 = 0; i1 < s1.length(); i1++) {
            for (int i2 = 0; i2 < s2.length(); i2++) {
                if (s1.charAt(i1) == s2.charAt(i2)) {
                    if (i1 == 0 || i2 == 0) {
                        dp[i1][i2] = 1;
                    } else {
                        dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                    }
                } else {
                    if (i1 == 0 || i2 == 0) {
                        dp[i1][i2] = 0;
                    } else {
                        dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
                    }
                }
                maxLength = Math.max(maxLength, dp[i1][i2]);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        MDITabulation mdi = new MDITabulation();
        mdi.findMDI("abc", "fbc");
        mdi.findMDI("abdca", "cbda");
        mdi.findMDI("passport", "ppsspt");
    }
}

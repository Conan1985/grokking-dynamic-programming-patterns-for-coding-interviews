package Pattern2.MaximumRibbonCut;

class CutRibbonTabulation {

    public int countRibbonPieces(int[] ribbonLengths, int total) {
        if (total == 0) {
            return 0;
        }
        int n = ribbonLengths.length;
        if (n <= 0) {
            return -1;
        }
        int[][] dp = new int[n][total + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= total; j++) {
                int count1 = Integer.MIN_VALUE;
                if (ribbonLengths[i] <= j) {
                    int res = dp[i][j - ribbonLengths[i]];
                    count1 = res != Integer.MIN_VALUE ? res + 1 : res;
                }
                int count2 = Integer.MIN_VALUE;
                if (i > 0) {
                    count2 = dp[i - 1][j];
                }
                dp[i][j] = Math.max(count1, count2);
            }
        }
        return dp[n - 1][total] == Integer.MIN_VALUE ? -1 : dp[n - 1][total];
    }

    public static void main(String[] args) {
        CutRibbonTabulation cr = new CutRibbonTabulation();
        int[] ribbonLengths = {2,3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[]{2,3};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{3,5,7};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[]{3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    }
}
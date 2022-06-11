package Pattern2.MaximumRibbonCut;

class CutRibbonMemoization {

    public int countRibbonPieces(int[] ribbonLengths, int total) {
        Integer[][] dp = new Integer[ribbonLengths.length][total + 1];
        int count = countRibbonPiecesRecursive(dp, ribbonLengths, total, 0);
        return count == Integer.MIN_VALUE ? -1 : count;
    }

    private int countRibbonPiecesRecursive(Integer[][] dp, int[] ribbonLengths, int total, int currentIndex) {
        if (total == 0) {
            return 0;
        }
        if (currentIndex >= ribbonLengths.length || ribbonLengths.length <= 0) {
            return Integer.MIN_VALUE;
        }
        if (dp[currentIndex][total] == null) {
            int count1 = Integer.MIN_VALUE;
            if (ribbonLengths[currentIndex] <= total) {
                int res = countRibbonPiecesRecursive(dp, ribbonLengths, total - ribbonLengths[currentIndex], currentIndex);
                count1 = res != Integer.MIN_VALUE ? res + 1 : res;
            }
            int count2 = countRibbonPiecesRecursive(dp, ribbonLengths, total, currentIndex + 1);
            dp[currentIndex][total] = Math.max(count1, count2);
        }
        return dp[currentIndex][total];
    }

    public static void main(String[] args) {
        CutRibbonMemoization cr = new CutRibbonMemoization();
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
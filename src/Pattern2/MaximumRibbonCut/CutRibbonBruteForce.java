package Pattern2.MaximumRibbonCut;

class CutRibbonBruteForce {

    public int countRibbonPieces(int[] ribbonLengths, int total) {
        int count = countRibbonPiecesRecursive(ribbonLengths, total, 0);
        return count == Integer.MIN_VALUE ? -1 : count;
    }

    private int countRibbonPiecesRecursive(int[] ribbonLengths, int total, int currentIndex) {
        if (total == 0) {
            return 0;
        }
        if (currentIndex >= ribbonLengths.length || ribbonLengths.length <= 0) {
            return Integer.MIN_VALUE;
        }
        int count1 = Integer.MIN_VALUE;
        if (ribbonLengths[currentIndex] <= total) {
            int res = countRibbonPiecesRecursive(ribbonLengths, total - ribbonLengths[currentIndex], currentIndex);
            count1 = res != Integer.MIN_VALUE ? res + 1 : res;
        }
        int count2 = countRibbonPiecesRecursive(ribbonLengths, total, currentIndex + 1);
        return Math.max(count1, count2);
    }

    public static void main(String[] args) {
        CutRibbonBruteForce cr = new CutRibbonBruteForce();
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
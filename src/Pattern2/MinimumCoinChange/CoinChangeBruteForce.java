package Pattern2.MinimumCoinChange;

class CoinChangeBruteForce {

    public int countChange(int[] denominations, int total) {
        int count = countChangeRecursive(denominations, total, 0);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int countChangeRecursive(int[] denominations, int total, int currentIndex ) {
        if (total == 0) {
            return 0;
        }
        if (denominations.length == 0 || currentIndex >= denominations.length) {
            return Integer.MAX_VALUE;
        }
        int count1 = Integer.MAX_VALUE;
        if (denominations[currentIndex] <= total) {
            int res = countChangeRecursive(denominations, total - denominations[currentIndex], currentIndex);
            count1 = res != Integer.MAX_VALUE ? res + 1 : count1;
        }
        int count2 = countChangeRecursive(denominations, total, currentIndex + 1);
        return Math.min(count1, count2);
    }

    public static void main(String[] args) {
        CoinChangeBruteForce cc = new CoinChangeBruteForce();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChange(denominations, 7));
    }
}
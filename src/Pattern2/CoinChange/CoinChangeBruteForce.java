package Pattern2.CoinChange;

class CoinChangeBruteForce {

    public int countChange(int[] denominations, int total) {
        return countChangeRecursive(denominations, total, 0);
    }

    private int countChangeRecursive(int[] denominations, int total, int currentIndex) {
        if (total == 0) {
            return 1;
        }
        if (currentIndex >= denominations.length) {
            return 0;
        }
        int sum1 = 0;
        if (denominations[currentIndex] <= total) {
            sum1 = countChangeRecursive(denominations, total - denominations[currentIndex], currentIndex);
        }
        int sum2 = countChangeRecursive(denominations, total, currentIndex + 1);
        return sum1 + sum2;
    }

    public static void main(String[] args) {
        CoinChangeBruteForce cc = new CoinChangeBruteForce();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
    }
}

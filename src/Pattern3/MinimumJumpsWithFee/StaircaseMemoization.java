package Pattern3.MinimumJumpsWithFee;

class StaircaseMemoization {

    public int findMinFee(int[] fee) {
        int n = fee.length;
        Integer[] dp = new Integer[n + 1];
        return findMinFeeRecursive(dp, fee, n);
    }

    private int findMinFeeRecursive(Integer[] dp, int[] fee, int currentIndex) {
        if (currentIndex == 0) {
            return 0;
        }
        if (currentIndex <= 2) {
            return fee[0];
        }
        if (dp[currentIndex] == null) {
            int price1 = findMinFeeRecursive(dp, fee, currentIndex - 1) + fee[currentIndex - 1];
            int price2 = findMinFeeRecursive(dp, fee, currentIndex - 2) + fee[currentIndex - 2];
            int price3 = findMinFeeRecursive(dp, fee, currentIndex - 3) + fee[currentIndex - 3];
            dp[currentIndex] = Math.min(price1, Math.min(price2, price3));
        }
        return dp[currentIndex];
    }

    public static void main(String[] args) {
        StaircaseMemoization sc = new StaircaseMemoization();
        int[] fee = {1,2,5,2,1,2};
        System.out.println(sc.findMinFee(fee));
        fee = new int[]{2,3,4,5};
        System.out.println(sc.findMinFee(fee));
    }
}

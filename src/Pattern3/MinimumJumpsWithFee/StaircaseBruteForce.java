package Pattern3.MinimumJumpsWithFee;

class StaircaseBruteForce {

    public int findMinFee(int[] fee) {
        return findMinFeeRecursive(fee, fee.length);
    }

    private int findMinFeeRecursive(int[] fee, int currentIndex) {
        if (currentIndex == 0) {
            return 0;
        }
        if (currentIndex <= 2) {
            return fee[0];
        }
        int price1 = findMinFeeRecursive(fee, currentIndex - 1) + fee[currentIndex - 1];
        int price2 = findMinFeeRecursive(fee, currentIndex - 2) + fee[currentIndex - 2];
        int price3 = findMinFeeRecursive(fee, currentIndex - 3) + fee[currentIndex - 3];
        return Math.min(price1, Math.min(price2, price3));
    }

    public static void main(String[] args) {
        StaircaseBruteForce sc = new StaircaseBruteForce();
        int[] fee = {1,2,5,2,1,2};
        System.out.println(sc.findMinFee(fee));
        fee = new int[]{2,3,4,5};
        System.out.println(sc.findMinFee(fee));
    }
}

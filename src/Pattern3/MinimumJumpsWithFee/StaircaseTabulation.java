package Pattern3.MinimumJumpsWithFee;

class StaircaseTabulation {

    public int findMinFee(int[] fee) {
        int n = fee.length;
        int dp3 = 0;
        int dp2 = fee[0];
        int dp1 = fee[0];
        for (int i = 3; i <=n; i++) {
            int price3 = dp3 + fee[i - 3];
            int price2 = dp2 + fee[i - 2];
            int price1 = dp1 + fee[i - 1];
            int temp = Math.min(price1, Math.min(price2, price3));
            dp3 = dp2;
            dp2 = dp1;
            dp1 = temp;
        }
        return dp1;
    }

    public static void main(String[] args) {
        StaircaseTabulation sc = new StaircaseTabulation();
        int[] fee = {1,2,5,2,1,2};
        System.out.println(sc.findMinFee(fee));
        fee = new int[]{2,3,4,5};
        System.out.println(sc.findMinFee(fee));
    }
}

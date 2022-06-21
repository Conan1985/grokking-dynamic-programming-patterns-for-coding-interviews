package Pattern3.HouseThief;

class HouseThiefTabulation {

    public int findMaxSteal(int[] wealth) {
        int n = wealth.length;
        int dp2 = wealth[0];
        int dp1 = Math.max(wealth[0], wealth[1]);
        for (int i = 2; i < n; i++) {
            int temp = Math.max(dp1, dp2 + wealth[i]);
            dp2 = dp1;
            dp1 = temp;
        }
        return dp1;
    }

    public static void main(String[] args) {
        HouseThiefTabulation ht = new HouseThiefTabulation();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));
    }
}

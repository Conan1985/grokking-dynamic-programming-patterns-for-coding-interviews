package Pattern3.HouseThief;

class HouseThiefBruteForce {

    public int findMaxSteal(int[] wealth) {
        return findMaxStealRecursive(wealth, wealth.length - 1);
    }

    private int findMaxStealRecursive(int[] wealth, int currentIndex) {
        if (currentIndex == 0) {
            return wealth[0];
        }
        if (currentIndex == 1) {
            return Math.max(wealth[0], wealth[1]);
        }
        return Math.max(findMaxStealRecursive(wealth, currentIndex - 1), findMaxStealRecursive(wealth, currentIndex - 2) + wealth[currentIndex]);
    }

    public static void main(String[] args) {
        HouseThiefBruteForce ht = new HouseThiefBruteForce();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));
    }
}

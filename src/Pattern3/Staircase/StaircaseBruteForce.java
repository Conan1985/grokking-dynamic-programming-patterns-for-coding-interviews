package Pattern3.Staircase;

class StaircaseBruteForce {

    public int CountWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int step1Ways = CountWays(n - 1);
        int step2Ways = CountWays(n - 2);
        int step3Ways = CountWays(n - 3);
        return step1Ways + step2Ways + step3Ways;
    }

    public static void main(String[] args) {
        StaircaseBruteForce sc = new StaircaseBruteForce();
        System.out.println(sc.CountWays(3));
        System.out.println(sc.CountWays(4));
        System.out.println(sc.CountWays(5));
    }
}

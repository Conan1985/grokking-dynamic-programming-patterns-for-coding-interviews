package Pattern3.NumberFactors;

class ExpressNumberBruteForce {

    public int CountWays(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        return CountWays(n - 1) + CountWays(n - 3) + CountWays(n - 4);
    }

    public static void main(String[] args) {
        ExpressNumberBruteForce en = new ExpressNumberBruteForce();
        System.out.println(en.CountWays(4));
        System.out.println(en.CountWays(5));
        System.out.println(en.CountWays(6));
    }
}
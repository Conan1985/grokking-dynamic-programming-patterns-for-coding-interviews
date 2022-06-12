package Pattern3.Staircase;

class StaircaseTabulation {

    public int CountWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int n0 = 1, n1 = 1, n2 = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    public static void main(String[] args) {
        StaircaseTabulation sc = new StaircaseTabulation();
        System.out.println(sc.CountWays(3));
        System.out.println(sc.CountWays(4));
        System.out.println(sc.CountWays(5));
    }
}

package Pattern1.TargetSum;

class TargetSumBruteForce {

    public int findTargetSubsets(int[] num, int s) {
        // TODO: Write your code here
        return findTargetSubsetsRecursive(num, s, 0);
    }

    private int findTargetSubsetsRecursive(int[] num, int s, int currentIndex) {
        if (currentIndex >= num.length) {
            if (s == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int sum1 = findTargetSubsetsRecursive(num, s + num[currentIndex], currentIndex + 1);
        int sum2 = findTargetSubsetsRecursive(num, s - num[currentIndex], currentIndex + 1);
        return sum1 + sum2;
    }



    public static void main(String[] args) {
        TargetSumBruteForce ts = new TargetSumBruteForce();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}
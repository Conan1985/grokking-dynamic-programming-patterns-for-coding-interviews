package Pattern1.CountofSubsetSum;

public class SubsetSum {
    public int countSubsets(int[] num, int sum) {
        return counterSubsetsRecursive(num, sum, 0);
    }

    private int counterSubsetsRecursive(int[] num, int sum, int currentIndex) {
        if (sum == 0) {
            return 1;
        }
        if (num.length == 0 || currentIndex >= num.length) {
            return 0;
        }
        int sum1 = counterSubsetsRecursive(num, sum - num[currentIndex], currentIndex + 1);
        int sum2 = counterSubsetsRecursive(num, sum, currentIndex + 1);
        return sum1 + sum2;
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}

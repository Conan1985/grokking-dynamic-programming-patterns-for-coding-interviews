package Pattern1.SubsetSum;

public class SubsetSumBruteForce {
    public boolean canPartition(int[] num, int sum) {
        return canPartitionRecursive(num, sum, 0);
    }

    private boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
        if (sum == 0) {
            return true;
        }
        if (num.length == 0 || currentIndex >= num.length) {
            return false;
        }
        if (num[currentIndex] <= sum) {
            if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1)) {
                return true;
            }
        }
        return canPartitionRecursive(num, sum, currentIndex + 1);
    }

    public static void main(String[] args) {
        SubsetSumBruteForce ss = new SubsetSumBruteForce();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }

}

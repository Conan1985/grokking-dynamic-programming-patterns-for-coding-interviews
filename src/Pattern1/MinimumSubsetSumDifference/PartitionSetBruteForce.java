package Pattern1.MinimumSubsetSumDifference;

class PartitionSetBruteForce {

    public int canPartition(int[] num) {
        // TODO: Write your code here
        return canPartitionRecursive(num, 0, 0, 0);
    }

    private int canPartitionRecursive(int[] num, int sum1, int sum2, int currentIndex) {
        if (currentIndex == num.length) {
            return Math.abs(sum1 - sum2);
        }
        int diff1 = canPartitionRecursive(num, sum1 + num[currentIndex], sum2, currentIndex + 1);
        int diff2 = canPartitionRecursive(num, sum1, sum2 + num[currentIndex], currentIndex + 1);
        return Math.min(diff1, diff2);
    }

    public static void main(String[] args) {
        PartitionSetBruteForce ps = new PartitionSetBruteForce();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
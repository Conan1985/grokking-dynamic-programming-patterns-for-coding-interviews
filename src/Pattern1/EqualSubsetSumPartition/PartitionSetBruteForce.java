package Pattern1.EqualSubsetSumPartition;

class PartitionSetBruteForce {

    public boolean canPartition(int[] num) {
        int sum = 0;
        for (int j : num) {
            sum += j;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return canPartitionRecursive(num, sum / 2, 0);
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
        PartitionSetBruteForce ps = new PartitionSetBruteForce();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
package Pattern5.LongestAlternatingSubsequence;

class LASMemoization {

    public int findLASLength(int[] nums) {
        Integer[][][] dp = new Integer[nums.length][nums.length][2];
        return Math.max(findLASLengthRecursive(dp, nums, -1, 0, true), findLASLengthRecursive(dp, nums, -1, 0, false));
    }

    private int findLASLengthRecursive(Integer[][][] dp, int[] nums, int previousIndex, int currentIndex, boolean isASC) {
        if (currentIndex == nums.length) {
            return 0;
        }
        if (dp[previousIndex + 1][currentIndex][isASC ? 1 : 0] == null) {
            int c1 = 0;
            if (isASC) {
                if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
                    c1 = 1 + findLASLengthRecursive(dp, nums, currentIndex, currentIndex + 1, false);
                }
            } else {
                if (previousIndex == -1 || nums[currentIndex] < nums[previousIndex]) {
                    c1 = 1 + findLASLengthRecursive(dp, nums, currentIndex, currentIndex + 1, true);
                }
            }
            int c2 = findLASLengthRecursive(dp, nums, previousIndex, currentIndex + 1, isASC);
            dp[previousIndex + 1][currentIndex][isASC ? 1 : 0] = Math.max(c1, c2);
        }
        return dp[previousIndex + 1][currentIndex][isASC ? 1 : 0];
    }

    public static void main(String[] args) {
        LASMemoization las = new LASMemoization();
        int[] nums = {1,2,3,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{3,2,1,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{1,3,2,4};
        System.out.println(las.findLASLength(nums));
    }
}

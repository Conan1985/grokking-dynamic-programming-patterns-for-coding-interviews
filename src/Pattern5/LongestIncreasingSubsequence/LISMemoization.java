package Pattern5.LongestIncreasingSubsequence;

class LISMemoization {

    public int findLISLength(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length + 1];
        return findLISLengthRecursive(nums, dp, 0, -1);
    }

    private int findLISLengthRecursive(int[] nums, Integer[][] dp, int currentIndex, int previousIndex) {
        if (currentIndex == nums.length) {
            return 0;
        }
        if (dp[currentIndex][previousIndex + 1] == null) {
            int c1 = 0;
            if (previousIndex < 0 || nums[currentIndex] > nums[previousIndex]) {
                c1 = 1 + findLISLengthRecursive(nums, dp, currentIndex + 1, currentIndex);
            }
            int c2 = findLISLengthRecursive(nums, dp, currentIndex + 1, previousIndex);
            dp[currentIndex][previousIndex + 1] = Math.max(c1, c2);
        }
        return dp[currentIndex][previousIndex + 1];
    }

    public static void main(String[] args) {
        LISMemoization lis = new LISMemoization();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lis.findLISLength(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(lis.findLISLength(nums));
    }
}

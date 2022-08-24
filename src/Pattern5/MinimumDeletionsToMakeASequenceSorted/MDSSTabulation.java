package Pattern5.MinimumDeletionsToMakeASequenceSorted;

class MDSSTabulation {

    public int findMinimumDeletions(int[] nums){
        return nums.length - findLongestIncreasingSubsequecne(nums);
    }

    private int findLongestIncreasingSubsequecne(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        MDSSTabulation mdss = new MDSSTabulation();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(mdss.findMinimumDeletions(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(mdss.findMinimumDeletions(nums));
        nums = new int[]{3,2,1,0};
        System.out.println(mdss.findMinimumDeletions(nums));
    }
}


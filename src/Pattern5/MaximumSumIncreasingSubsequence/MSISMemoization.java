package Pattern5.MaximumSumIncreasingSubsequence;

import java.util.HashMap;
import java.util.Map;

class MSISMemoization {

    public int findMSIS(int[] nums) {
        Map<String, Integer> dp = new HashMap<>();
        return findMSISRecursive(dp, nums, 0, -1, 0);
    }

    private int findMSISRecursive(Map<String, Integer> dp, int[] nums, int currentIndex, int previousIndex, int sum) {
        if (currentIndex == nums.length) {
            return sum;
        }
        String key = currentIndex + "|" + previousIndex + "|" + sum;
        if (!dp.containsKey(key)) {
            int s1 = sum;
            if (previousIndex < 0 || nums[currentIndex] > nums[previousIndex]) {
                s1 = findMSISRecursive(dp, nums, currentIndex + 1, currentIndex, sum + nums[currentIndex]);
            }
            int s2 = findMSISRecursive(dp, nums, currentIndex + 1, previousIndex, sum);
            dp.put(key, Math.max(s1, s2));
        }
        return dp.get(key);
    }

    public static void main(String[] args) {
        MSISMemoization msis = new MSISMemoization();
        int[] nums = {4,1,2,6,10,1,12};
        System.out.println(msis.findMSIS(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(msis.findMSIS(nums));
        nums = new int[]{1,3,8,4,14,6,14,1,9,4,13,3,11,17,29};
        System.out.println(msis.findMSIS(nums));
    }
}
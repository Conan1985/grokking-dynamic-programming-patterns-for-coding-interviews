package Pattern5.LongestAlternatingSubsequence;

class LASBruteForce {

    public int findLASLength(int[] nums) {
        return Math.max(findLASLengthRecursive(nums, -1, 0, true), findLASLengthRecursive(nums, -1, 0, false));
    }

    private int findLASLengthRecursive(int[] nums, int previousIndex, int currentIndex, boolean isASC) {
        if (currentIndex == nums.length) {
            return 0;
        }
        int c1 = 0;
        if (isASC) {
            if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
                c1 = 1 + findLASLengthRecursive(nums, currentIndex, currentIndex + 1, false);
            }
        } else {
            if (previousIndex == -1 || nums[currentIndex] < nums[previousIndex]) {
                c1 = 1 + findLASLengthRecursive(nums, currentIndex, currentIndex + 1, true);
            }
        }
        int c2 = findLASLengthRecursive(nums, previousIndex, currentIndex + 1, isASC);
        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        LASBruteForce las = new LASBruteForce();
        int[] nums = {1,2,3,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{3,2,1,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{1,3,2,4};
        System.out.println(las.findLASLength(nums));
    }
}

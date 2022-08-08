package Pattern5.MaximumSumIncreasingSubsequence;

class MSISBruteForce {

    public int findMSIS(int[] nums) {
        return findMSISRecursive(nums, 0, -1, 0);
    }

    private int findMSISRecursive(int[] nums, int currentIndex, int previousIndex, int sum) {
        if (currentIndex == nums.length) {
            return sum;
        }
        int s1 = sum;
        if (previousIndex < 0 || nums[currentIndex] > nums[previousIndex]) {
            s1 = findMSISRecursive(nums, currentIndex + 1, currentIndex, sum + nums[currentIndex]);
        }
        int s2 = findMSISRecursive(nums, currentIndex + 1, previousIndex, sum);
        return Math.max(s1, s2);
    }

    public static void main(String[] args) {
        MSISBruteForce msis = new MSISBruteForce();
        int[] nums = {4,1,2,6,10,1,12};
        System.out.println(msis.findMSIS(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(msis.findMSIS(nums));
        nums = new int[]{1,3,8,4,14,6,14,1,9,4,13,3,11,17,29};
        System.out.println(msis.findMSIS(nums));
    }
}
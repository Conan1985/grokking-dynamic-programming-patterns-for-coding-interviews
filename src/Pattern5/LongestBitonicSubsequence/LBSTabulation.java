package Pattern5.LongestBitonicSubsequence;

class LBSTabulation {

    private int findLBSLength(int[] nums) {
        int[] lbs = new int[nums.length];
        int[] lbsRev = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            lbs[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    lbs[i] = Math.max(lbs[i], lbs[j] + 1);
                }
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            lbsRev[i] = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    lbsRev[i] = Math.max(lbsRev[i], lbsRev[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, lbs[i] + lbsRev[i] - 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LBSTabulation lbs = new LBSTabulation();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lbs.findLBSLength(nums));
        nums = new int[]{4,2,5,9,7,6,10,3,1};
        System.out.println(lbs.findLBSLength(nums));
    }
}

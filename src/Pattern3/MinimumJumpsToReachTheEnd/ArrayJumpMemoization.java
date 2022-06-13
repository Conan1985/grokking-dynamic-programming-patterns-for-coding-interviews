package Pattern3.MinimumJumpsToReachTheEnd;

class ArrayJumpMemoization {

    public int countMinJumps(int[] jumps) {
        Integer[] dp = new Integer[jumps.length];
        return countMinJumpsRecursive(dp, jumps, 0);
    }

    private int countMinJumpsRecursive(Integer[] dp, int[] jumps, int currentIndex) {
        if (currentIndex == jumps.length - 1) {
            return 0;
        }
        if (currentIndex >= jumps.length || jumps.length == 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[currentIndex] == null) {
            int totalJumps = Integer.MAX_VALUE;
            for (int end = currentIndex + 1; end <= currentIndex + jumps[currentIndex] && end < jumps.length; end++) {
                int minJumps = countMinJumpsRecursive(dp, jumps, end);
                if (minJumps != Integer.MAX_VALUE) {
                    totalJumps = Math.min(minJumps + 1, totalJumps);
                }
            }
            dp[currentIndex] = totalJumps;
        }
        return dp[currentIndex];
    }

    public static void main(String[] args) {
        ArrayJumpMemoization aj = new ArrayJumpMemoization();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
    }
}
package Pattern3.MinimumJumpsToReachTheEnd;

class ArrayJumpTabulation {

    public int countMinJumps(int[] jumps) {
        int n = jumps.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int start = 0; start < n; start ++) {
            for (int end = start + 1; end <= start + jumps[start] && end < jumps.length; end++) {
                dp[end] = Math.min(dp[end], dp[start] + 1);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        ArrayJumpTabulation aj = new ArrayJumpTabulation();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
    }
}
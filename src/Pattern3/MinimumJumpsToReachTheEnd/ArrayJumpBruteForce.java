package Pattern3.MinimumJumpsToReachTheEnd;

class ArrayJumpBruteForce {

    public int countMinJumps(int[] jumps) {
        return countMinJumpsRecursive(jumps, 0);
    }

    private int countMinJumpsRecursive(int[] jumps, int currentIndex) {
        if (currentIndex == jumps.length - 1) {
            return 0;
        }
        if (currentIndex >= jumps.length || jumps.length == 0) {
            return Integer.MAX_VALUE;
        }
        int totalJumps = Integer.MAX_VALUE;
        for (int end = currentIndex + 1; end <= currentIndex + jumps[currentIndex] && end < jumps.length; end++) {
            int minJumps = countMinJumpsRecursive(jumps, end);
            if (minJumps != Integer.MAX_VALUE) {
                totalJumps = Math.min(minJumps + 1, totalJumps);
            }
        }
        return totalJumps;
    }

    public static void main(String[] args) {
        ArrayJumpBruteForce aj = new ArrayJumpBruteForce();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
    }
}
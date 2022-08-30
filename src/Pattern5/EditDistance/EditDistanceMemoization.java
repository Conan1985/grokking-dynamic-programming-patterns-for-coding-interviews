package Pattern5.EditDistance;

class EditDistanceMemoization {

    public int findMinOperations(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];
        return findMinOperationsRecursive(dp, s1, s2, 0, 0);
    }

    private int findMinOperationsRecursive(Integer[][] dp, String s1, String s2, int i1, int i2) {
        if (i1 == s1.length()) {
            return dp[i1][i2] = s2.length() - i2;
        }
        if (i2 == s2.length()) {
            return dp[i1][i2] = s1.length() - i1;
        }
        if (dp[i1][i2] == null) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                dp[i1][i2] = findMinOperationsRecursive(dp, s1, s2, i1 + 1, i2 + 1);
            } else {
                int c1 = findMinOperationsRecursive(dp, s1, s2, i1 + 1, i2 + 1);
                int c2 = findMinOperationsRecursive(dp, s1, s2, i1 + 1, i2);
                int c3 = findMinOperationsRecursive(dp, s1, s2, i1, i2 + 1);
                dp[i1][i2] = 1 + Math.min(c1, Math.min(c2, c3));
            }
        }
        return dp[i1][i2];
    }

    public static void main(String[] args) {
        EditDistanceMemoization editDisatnce = new EditDistanceMemoization();
        System.out.println(editDisatnce.findMinOperations("bat", "but"));
        System.out.println(editDisatnce.findMinOperations("abdca", "cbda"));
        System.out.println(editDisatnce.findMinOperations("passpot", "ppsspqrt"));
    }
}
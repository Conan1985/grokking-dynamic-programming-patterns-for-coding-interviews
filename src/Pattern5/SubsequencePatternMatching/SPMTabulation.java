package Pattern5.SubsequencePatternMatching;

class SPMTabulation {

    public int findSPMCount(String str, String pat) {
        if (pat.length() == 0) {
            return 1;
        }
        if (str.length() == 0 || str.length() < pat.length()) {
            return 0;
        }
        int[][] dp = new int[str.length() + 1][pat.length() + 1];
        for (int i = 0; i <= str.length(); i++) {
            dp[i][0] = 1;
        }
        for (int strIndex = 1; strIndex <= str.length(); strIndex++) {
            for (int patIndex = 1; patIndex <= pat.length(); patIndex++) {
                if (str.charAt(strIndex - 1) == pat.charAt(patIndex - 1)) {
                    dp[strIndex][patIndex] = dp[strIndex - 1][patIndex - 1];
                }
                dp[strIndex][patIndex] += dp[strIndex - 1][patIndex];
            }
        }
        return dp[str.length()][pat.length()];
    }

    public static void main(String[] args) {
        SPMTabulation spm = new SPMTabulation();
        System.out.println(spm.findSPMCount("baxmx", "ax"));
        System.out.println(spm.findSPMCount("tomorrow", "tor"));
    }
}

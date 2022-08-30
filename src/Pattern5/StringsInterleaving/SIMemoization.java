package Pattern5.StringsInterleaving;

class SIMemoization {

    public boolean findSI(String m, String n, String p) {
        // TODO: Write your code here
        Boolean[][] dpM = new Boolean[m.length()][p.length()];
        Boolean[][] dpN = new Boolean[n.length()][p.length()];
        return findSIRecursive(dpM, m, p, 0, 0) && findSIRecursive(dpN, n, p, 0, 0);
    }

    private boolean findSIRecursive(Boolean[][] dp, String x, String p, int ix, int ip) {
        if (ix == x.length()) {
            return true;
        }
        if (ip == p.length()) {
            return false;
        }
        if (dp[ix][ip] == null) {
            if (x.charAt(ix) == p.charAt(ip)) {
                dp[ix][ip] = findSIRecursive(dp, x, p, ix + 1, ip + 1);
            } else {
                dp[ix][ip] = findSIRecursive(dp, x, p, ix, ip + 1);
            }
        }
        return dp[ix][ip];
    }

    public static void main(String[] args) {
        SIMemoization si = new SIMemoization();
        System.out.println(si.findSI("abd", "cef", "abcdef"));
        System.out.println(si.findSI("abd", "cef", "adcbef"));
        System.out.println(si.findSI("abc", "def", "abdccf"));
        System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
    }
}
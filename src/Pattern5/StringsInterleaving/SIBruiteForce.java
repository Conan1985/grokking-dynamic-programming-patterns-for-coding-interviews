package Pattern5.StringsInterleaving;

class SIBruiteForce {

    public boolean findSI(String m, String n, String p) {
        return findSIRecursive(m, p, 0, 0) && findSIRecursive(n, p, 0, 0);
    }

    private boolean findSIRecursive(String x, String p, int ix, int ip) {
        if (ix == x.length()) {
            return true;
        }
        if (ip == p.length()) {
            return false;
        }
        if (x.charAt(ix) == p.charAt(ip)) {
            return findSIRecursive(x, p, ix + 1, ip + 1);
        }
        return findSIRecursive(x, p, ix, ip + 1);
    }

    public static void main(String[] args) {
        SIBruiteForce si = new SIBruiteForce();
        System.out.println(si.findSI("abd", "cef", "abcdef"));
        System.out.println(si.findSI("abd", "cef", "adcbef"));
        System.out.println(si.findSI("abc", "def", "abdccf"));
        System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
    }
}
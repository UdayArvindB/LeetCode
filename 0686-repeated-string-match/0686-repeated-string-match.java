class Solution {
    private static final int BASE = 256;
    private static final int MOD = 101;

    public int repeatedStringMatch(String a, String b) {
         StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (rabinKarp(sb.toString(), b)) {
            return count;
        }
        sb.append(a);
        count++;
        if (rabinKarp(sb.toString(), b)) {
            return count;
        }
        return -1;
    }
    private boolean rabinKarp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if (m > n) return false;
        int patternHash = 0;
        int windowHash = 0;
        int h = 1;
        for (int i = 0; i < m - 1; i++) {
            h = (h * BASE) % MOD;
        }
        for (int i = 0; i < m; i++) {
            patternHash = (BASE * patternHash + pattern.charAt(i)) % MOD;
            windowHash = (BASE * windowHash + text.charAt(i)) % MOD;
        }
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == windowHash) {
                int j = 0;
                while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    return true;
                }
            }
            if (i < n - m) {
                windowHash = (BASE * (windowHash - text.charAt(i) * h) + text.charAt(i + m)) % MOD;
                if (windowHash < 0) {
                    windowHash += MOD;
                }
            }
        }
        return false;
    }
}
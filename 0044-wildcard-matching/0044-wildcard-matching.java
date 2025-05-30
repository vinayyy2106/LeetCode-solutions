class Solution {
    public boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();

    int[][] dp = new int[n][m];
    for (int[] row : dp) {
        Arrays.fill(row, -1);
    }

    return ifMatching(s, p, n - 1, m - 1, dp);
}

public boolean ifMatching(String s, String p, int i, int j, int[][] dp) {
    if (i < 0 && j < 0) return true; // both strings exhausted
    if (i < 0) return isAllStars(p, j); // s exhausted, p can be only *
    if (j < 0) return false; // p exhausted but s not

    if (dp[i][j] != -1) return dp[i][j] == 1;

    boolean match = false;

    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
        match = ifMatching(s, p, i - 1, j - 1, dp);
    } else if (p.charAt(j) == '*') {
        match = ifMatching(s, p, i - 1, j, dp) || ifMatching(s, p, i, j - 1, dp);
    }

    dp[i][j] = match ? 1 : 0;
    return match;
}
private boolean isAllStars(String p, int j) {
    for (int k = 0; k <= j; k++) {
        if (p.charAt(k) != '*') return false;
    }
    return true;
}
}
class Solution {

    int[][] dp;

    public int solve(String s, String t, int i, int j) {

        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {

            int take = solve(s, t, i + 1, j + 1);

            int skip = solve(s, t, i + 1, j);

            dp[i][j] = take + skip;

        } else {

            dp[i][j] = solve(s, t, i + 1, j);
        }

        return dp[i][j];
    }

    public int numDistinct(String s, String t) {

        dp = new int[s.length()][t.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return solve(s, t, 0, 0);
    }
}
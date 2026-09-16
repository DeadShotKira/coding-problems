class Solution {
    public int numberOfSets(int n, int k) {
        final int MOD = 1_000_000_007;

        long[][] C = new long[n + k][2 * k + 1];

        for (int i = 0; i <= n + k - 1; i++) {
            C[i][0] = 1;

            for (int j = 1; j <= Math.min(i, 2 * k); j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        return (int) C[n + k - 1][2 * k];
    }
}
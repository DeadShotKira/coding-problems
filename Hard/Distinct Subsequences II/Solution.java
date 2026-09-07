class Solution {

    public int distinctSubseqII(String s) {

        long MOD = 1000000007;

        long[] last = new long[26];

        long dp = 1;

        for (char c : s.toCharArray()) {

            int index = c - 'a';

            long oldDp = dp;

            dp = (2 * dp - last[index] + MOD) % MOD;

            last[index] = oldDp;
        }

        return (int) ((dp - 1 + MOD) % MOD);
    }
}
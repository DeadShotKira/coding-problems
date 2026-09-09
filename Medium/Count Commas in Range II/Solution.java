class Solution {
    public long countCommas(long n) {
        long count = 0;

        if (n < 1000) {
            return 0;
        }

        // 1,000 to 999,999 → 1 comma
        count += Math.min(n, 999999L) - 999;

        // 1,000,000 to 999,999,999 → 2 commas
        if (n >= 1000000L) {
            count += (Math.min(n, 999999999L) - 999999L) * 2;
        }

        // 1,000,000,000 to 999,999,999,999 → 3 commas
        if (n >= 1000000000L) {
            count += (Math.min(n, 999999999999L) - 999999999L) * 3;
        }

        // 1,000,000,000,000 to 999,999,999,999,999 → 4 commas
        if (n >= 1000000000000L) {
            count += (Math.min(n, 999999999999999L) - 999999999999L) * 4;
        }

        // 1,000,000,000,000,000 to 999,999,999,999,999,999 → 5 commas
        if (n >= 1000000000000000L) {
            count += (Math.min(n, 999999999999999999L) - 999999999999999L) * 5;
        }

        return count;
    }
}
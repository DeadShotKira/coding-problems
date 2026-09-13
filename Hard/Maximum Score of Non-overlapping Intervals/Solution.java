class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        
        int n = intervals.size();

        // Store: [left, right, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by right endpoint
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);

            return Integer.compare(a[3], b[3]);
        });

        // prev[i] = last interval that ends BEFORE arr[i] starts
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = i - 1;
            int ans = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid][1] < arr[i][0]) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            prev[i] = ans;
        }

        // dp[k][i] = best score using first i intervals
        // and selecting at most k intervals
        long[][] dp = new long[5][n + 1];

        // chosen[k][i] stores the indices chosen for this state
        int[][][] chosen = new int[5][n + 1][];

        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i <= n; i++) {
                chosen[k][i] = new int[0];
            }
        }

        for (int k = 1; k <= 4; k++) {

            for (int i = 1; i <= n; i++) {

                // Don't take current interval
                dp[k][i] = dp[k][i - 1];
                chosen[k][i] = chosen[k][i - 1];

                // Take current interval
                int p = prev[i - 1] + 1;

                long takeScore =
                    dp[k - 1][p] + arr[i - 1][2];

                int[] old = chosen[k - 1][p];

                int[] takeIndices =
                    Arrays.copyOf(old, old.length + 1);

                takeIndices[takeIndices.length - 1] =
                    arr[i - 1][3];

                // Sort because answer must be lexicographically ordered
                Arrays.sort(takeIndices);

                // Check which option is better
                if (takeScore > dp[k][i]) {

                    dp[k][i] = takeScore;
                    chosen[k][i] = takeIndices;

                } else if (takeScore == dp[k][i]) {

                    if (lexicographicallySmaller(
                            takeIndices,
                            chosen[k][i])) {

                        chosen[k][i] = takeIndices;
                    }
                }
            }
        }

        return chosen[4][n];
    }

    private boolean lexicographicallySmaller(int[] a, int[] b) {

        int n = Math.min(a.length, b.length);

        for (int i = 0; i < n; i++) {

            if (a[i] < b[i])
                return true;

            if (a[i] > b[i])
                return false;
        }

        return a.length < b.length;
    }
}
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        // best[i] = minimum length of a valid subarray
        // completely within indices 0 to i
        int[] best = new int[n];

        int INF = 1000000;

        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int answer = INF;
        int minLength = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // Shrink window if sum becomes greater than target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // We found a subarray [left...right]
            if (sum == target) {
                int length = right - left + 1;

                // Check if there was a non-overlapping
                // subarray before 'left'
                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(answer,
                            best[left - 1] + length);
                }

                // Keep the shortest valid subarray seen so far
                minLength = Math.min(minLength, length);
            }

            // Carry forward the best answer
            // up to this index
            if (right == 0) {
                best[right] = minLength;
            } else {
                best[right] = Math.min(best[right - 1], minLength);
            }
        }

        return answer == INF ? -1 : answer;
    }
}
class Solution {
    public int largestInteger(int[] nums, int k) {

        int[] count = new int[51];

        // Check every subarray of size k
        for (int i = 0; i <= nums.length - k; i++) {

            boolean[] seen = new boolean[51];

            for (int j = i; j < i + k; j++) {

                if (!seen[nums[j]]) {
                    count[nums[j]]++;
                    seen[nums[j]] = true;
                }
            }
        }

        // Find largest number appearing in exactly one window
        for (int i = 50; i >= 0; i--) {
            if (count[i] == 1) {
                return i;
            }
        }

        return -1;
    }
}
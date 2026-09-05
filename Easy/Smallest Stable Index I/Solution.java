class Solution {
    public int compute(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = k; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        return min;
    }

    public int firstStableIndex(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            int min = compute(nums, i);

            if (max - min <= k) {
                return i;
            }
        }

        return -1;
    }
}
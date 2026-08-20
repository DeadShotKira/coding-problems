class Solution {
    public int maxProduct(int[] nums) {
         int best = -1;
        int secondBest = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= best) {
                secondBest = best;
                best = nums[i];
            } else if (nums[i] >= secondBest) {
                secondBest = nums[i];
            }
        }

        return (best-1) * (secondBest-1);
    }
}
class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int i = nums[0];
        while(i>0)
        {
           if(nums[0] % i == 0 && nums[nums.length - 1] % i == 0)
           {
            break;
           }

           i--;
        }

        return i;
    }
}
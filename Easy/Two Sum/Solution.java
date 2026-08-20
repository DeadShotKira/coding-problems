class Solution {
    public int[] twoSum(int[] nums, int target) {
        
       int[] ans = new int[2];
        for(int i = 1; i < nums.length; i++)
        {
            for(int j =  i; j<nums.length; j++)
            {
                
                if(nums[j] + nums[j-i] == target)
                    return new int[] {j - i , j};                            
                             
            }
            
        }
        
        return null;
    }
}
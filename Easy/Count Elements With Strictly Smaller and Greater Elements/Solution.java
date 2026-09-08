class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length - 2;    

        int val = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(val != nums[i])
            break;

            n--;
        }

        val = nums[nums.length-1];
        for(int i = nums.length-2; i>=0; i--){
            if(val != nums[i])
            break;

            n--;
        }

        return (n>0) ? n: 0;
        
    }
}
class Solution {
    public int minimumDeletions(int[] nums) {

       int ops = Integer.MAX_VALUE;
       int min = nums[0];
       int max = nums[0];
       int count = 0;
       int currOps = 0;

       for(int i = 0; i< nums.length; i++){
        if(nums[i] < min) min = nums[i];
        if(nums[i] > max) max = nums[i];
       }

       for(int i = 0; i < nums.length; i++){
        currOps++;
        if(nums[i] == min || nums[i] == max){
            count++;
            if(count == 2) break;
        }
       }

       ops = Math.min(ops, currOps);
       currOps = 0;
       count = 0;


       for(int i = nums.length - 1; i >= 0 ; i--){
        currOps++;
        if(nums[i] == min || nums[i] == max){
            count++;
            if(count == 2) break;
        }
       }

       ops = Math.min(ops, currOps);
       currOps = 0;
       count = 0;

       for(int i = 0; i < nums.length; i++){
        currOps++;
        if(nums[i] == min || nums[i] == max){
            count++;
            if(count == 1){
                for(int j = nums.length - 1; j >= 0 ; j--){
                    currOps++;
                    if(nums[j] == min || nums[j] == max){
                    count++;
                    if(count == 2) break;
                }
            }
            break;
        }
       }
       }

       ops = Math.min(ops, currOps);
       currOps = 0;
       count = 0;

       for(int i = nums.length - 1; i >= 0 ; i--){
        currOps++;
        if(nums[i] == min || nums[i] == max){
            count++;
            if(count == 1){
                for(int j = 0; j < nums.length; j++){
                    currOps++;
                    if(nums[j] == min || nums[j] == max){
                    count++;
                    if(count == 2) break;
                }
            }
            break;
        }
        }
       }

       ops = Math.min(ops, currOps);

       return ops;
    }
}
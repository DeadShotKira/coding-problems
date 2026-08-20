class Solution {
    public int averageValue(int[] nums) {
        int sum = 0 ;
        int num = 0;
        for(int n : nums){
            if(n % 6 == 0){
                sum+= n;
                num++;
            }
        }

        if(num == 0){
            return 0;
        }

        return (sum / num);

    }
}
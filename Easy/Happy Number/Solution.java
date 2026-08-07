class Solution {
    public boolean isHappy(int n) {
        int sum, digit;
        while(true){
            sum = 0;
            while(n>0){
                digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
            if(sum == 1){
                return true;
            }
            else if(sum== 4){
                return false;
            }
        }
    }
}
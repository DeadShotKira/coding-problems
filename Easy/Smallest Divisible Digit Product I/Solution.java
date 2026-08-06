class Solution {
    public int smallestNumber(int n, int t) {
        int prod;
        int num;
        for(int i = 0 ; i < 10; i++){
            num = n;
            prod = (num%10);
            num /= 10;
            while(num != 0){
                prod *= (num%10);
                num /= 10; 
            }

            if(prod % t == 0){
                return n  ;
            }
            n++;
        }
        return 0;
    }
}
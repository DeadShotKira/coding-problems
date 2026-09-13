class Solution {
    public int totalNumbers(int[] digits) {
       int[] d = new int[10];
       int count = 0;

       for(int i : digits){
         d[i]++;
       }

       for(int n = 100; n<1000; n++){
        if(n%2!=0)
        continue;

        int num[] = new int[10];
        int temp = n;
        while(temp>0){
            num[temp%10]++;
            temp /=10;
        }

        boolean value = true;

        for(int i = 0; i<d.length; i++){
            if(d[i]<num[i]){
                value = false;
                break;
            }
        }

        if(value)
        count++;
       }

       return count;
    }
}
class Solution {
    public void reverseString(char[] s) {
        rev(s, 0, s.length -1);
    }

    public void rev(char[] s , int left, int right){

        if(left >= right){
            return;
        }

        char c = s[left];
        s[left] = s[right];
        s[right] = c;

        rev(s, left+1, right-1);
    }
}
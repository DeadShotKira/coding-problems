class Solution {
    public boolean isPowerOfFour(int n) {
        return check(n);
    }

    boolean check(int n){
        if (n == 1) return true;      // base case
        if (n <= 0 || n % 4 != 0) return false;

        return isPowerOfFour(n / 4);  // recursion
    }
}
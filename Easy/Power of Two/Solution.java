class Solution {
    public boolean isPowerOfTwo(int n) {
        return check(n);
    }

    boolean check(int n){
        if (n == 1) return true;      // base case
        if (n <= 0 || n % 2 != 0) return false;

        return isPowerOfTwo(n / 2);  // recursion
    }
}
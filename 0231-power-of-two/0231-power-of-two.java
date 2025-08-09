class Solution {
    public boolean isPowerOfTwo(int n) {
        return checkPower(n);
    }
    public boolean checkPower(int n){
        if(n<=0)return false;
        return n>0 && (n & (n-1))==0;
    }
}
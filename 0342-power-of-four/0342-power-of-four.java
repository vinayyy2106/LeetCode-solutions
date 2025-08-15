class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0)return false;
        return helper(n);
    }
    public boolean helper(int n){
        if(n==1)return true;
        if(n>1 && n<4)return false;
        if(n%4!=0)return false;
        boolean status=false;
        if(n%4==0){
            status=helper(n/4);
        }
        return status;
    }
}
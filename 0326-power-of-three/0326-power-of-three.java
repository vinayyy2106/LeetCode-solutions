class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0)return false;
        return helper(n);
    }
    public boolean helper(int n){
        if(n==1)return true;
        if(n>1 && n<3)return false;
        if(n%3!=0)return false;
        boolean status=false;
        if(n%3==0){
            status=helper(n/3);
        }
        return status;
    }
}
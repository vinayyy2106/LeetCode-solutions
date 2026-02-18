class Solution {
    public boolean hasAlternatingBits(int n) {
       String nextOne="";
       String nextZero="";
       int val=n&1;
       if(val==1){
           nextZero="yes";
       }else{
           nextOne="yes";
       }
       n=n>>1;
       while(n>0){
        if(nextZero=="yes"){
            int checkVal=n&1;
            if(checkVal==1){
                return false;
            }else{
                nextOne="yes";
                nextZero="no";
                n=n>>1;
            }
        }
        else{
            int checkVall=n&1;
            if(checkVall==0){
                return false;
            }else{
                nextOne="no";
                nextZero="yes";
                n=n>>1;
            }
        }
       } 
       return true;
    }
}
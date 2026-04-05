class Solution {
    public boolean judgeCircle(String moves) {
        int i=0,j=0;
        for(char ch:moves.toCharArray()){
            if(ch=='U'){
                i=i-1;
            }else if(ch=='R'){
                j=j+1;
            }else if(ch=='L'){
                j=j-1;
            }else{
                i=i+1;
            }
        }
        if(i==0 && j==0)return true;
        return false;
    }
}
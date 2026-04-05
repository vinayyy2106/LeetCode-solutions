class Solution {
    public boolean judgeCircle(String moves) {
        int i=0,j=0;
        for(char ch:moves.toCharArray()){
            if(ch=='U'){
                i--;
            }else if(ch=='R'){
                j++;
            }else if(ch=='L'){
                j--;
            }else{
                i++;
            }
        }
        if(i==0 && j==0)return true;
        return false;
    }
}
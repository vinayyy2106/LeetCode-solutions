class Solution {
    public boolean doesAliceWin(String s) {
        int count=0;
        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                count++;
            }
        }
        if(count==0){
            return false;
        }else{
            return true;//for even,odd nd not zero
        }
    }
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }
}
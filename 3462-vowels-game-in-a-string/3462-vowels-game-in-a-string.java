class Solution {
    public boolean doesAliceWin(String s) {
        int count=0;
        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                return true;//for even,odd nd not zero
            }
        }
        return false;//for zero vowels
    }
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }
}
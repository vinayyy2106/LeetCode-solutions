class Solution {
    public int possibleStringCount(String word) {
        int count=1;
        char ch=word.charAt(0);
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==ch){
                count++;
            }
            ch=word.charAt(i);
        }
        return count;
    }
}
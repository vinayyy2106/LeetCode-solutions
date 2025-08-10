class Solution {
    public int firstUniqChar(String s) {
        int[] charArray=new int[26];
        for(int i=0;i<s.length();i++){
            charArray[s.charAt(i)-'a']++;
        }
        int index=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(charArray[i]==1){
                index=Math.min(index,s.indexOf((char)(i+'a')));
            }
        }
        return index==Integer.MAX_VALUE?-1:index;
    }
}
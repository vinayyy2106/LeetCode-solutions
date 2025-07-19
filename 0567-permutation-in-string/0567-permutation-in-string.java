class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] charArray=new int[26];
        for(char ch:s1.toCharArray()){
            charArray[ch-'a']++;
        }
        int i=0;
        int j=0;
        int n=s2.length();
        int total_char=s1.length();
        while(j<n){
            if(charArray[s2.charAt(j)-'a']>0){
                charArray[s2.charAt(j)-'a']--;
                total_char--;
                j++;
            }else if(j-i==s1.length()){
                if (charArray[s2.charAt(i) - 'a'] >= 0) {
                    total_char++;
                }
                charArray[s2.charAt(i) - 'a']++;
                i++;
            }else{
                if (charArray[s2.charAt(i) - 'a'] >= 0) {
                    total_char++;
                }
                charArray[s2.charAt(i) - 'a']++;
                i++;
            }
            if(total_char==0 && j-i==s1.length())return true;
        }
        return false;
    }
}
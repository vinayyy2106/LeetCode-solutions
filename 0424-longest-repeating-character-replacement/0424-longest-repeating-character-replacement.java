class Solution {
    public int characterReplacement(String s, int k) {
        int[] frq=new int[26];
        int n=s.length();
        int maxFreq=0;
        int i=0;
        int j=0;
        int maxLen=0;
        while(j<n){
            frq[s.charAt(j)-'A']++;
            maxFreq=Math.max(maxFreq,frq[s.charAt(j)-'A']);
            if((j-i+1)-maxFreq > k){
                frq[s.charAt(i)-'A']--;
                i++;
            }
            maxLen=Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}
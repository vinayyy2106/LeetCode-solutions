class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1)return s;
        int a=0;
        int maxLen=1;
        int start=0;
        int end=0;
        for(int i=1;i<s.length();i++){
            //even
            start=i-1;
            end=i;
            while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
                start--;
                end++;
            }
            if(end-start-1>maxLen){
                maxLen=end-start-1;
                a=start+1;
            }
            //odd
            start=i-1;
            end=i+1;
            while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
                start--;
                end++;
            }
            if(end-start-1>maxLen){
                maxLen=end-start-1;
                a=start+1;
            }
            
        }
        return s.substring(a,a+maxLen);
    }
}
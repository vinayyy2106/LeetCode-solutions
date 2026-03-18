class Solution {
    boolean[][] dp;
    public String longestPalindrome(String s) {
        int max_len=0;
        int ind=0;
        dp=new boolean[s.length()+1][s.length()+1];
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(i,j,s)){
                    if(j-i+1 > max_len){
                        ind=i;
                        max_len=j-i+1;
                    }
                }
            }
        }
        return s.substring(ind,ind+max_len);
    }
    public boolean isPalindrome(int i,int j,String s){
        if(i>=j)return true;
        if(dp[i][j]!=false)return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=isPalindrome(i+1,j-1,s);
        }
        return dp[i][j]=false;
    }
}
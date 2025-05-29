class Solution {
    public int minInsertions(String s) {
        //find the reverse of string first and then find the common longest subseq btw original and reevrse which is nothing but longest palindromic sub seq then subtract it from the origibal string length so we get the min insertions
        StringBuilder st=new StringBuilder(s);
        String t=st.reverse().toString();
        return longestCommonSubsequence(s,t,t.length());
    }
    public int longestCommonSubsequence(String s,String t,int len){
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return len-dp[n][m];
    }
}
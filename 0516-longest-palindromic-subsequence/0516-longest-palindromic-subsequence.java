class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder st=new StringBuilder(s);
        String t=st.reverse().toString();
        return longestCommonSubsequence(s,t);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // return lengthOfSequence(text1.length(),text2.length(),text1,text2,dp);
        //tabulation
        int n=text1.length();
        int m=text2.length();
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m;j++){
            dp[0][j]=0;
        }
        for(int i1=1;i1<=n;i1++){
            for(int i2=1;i2<=m;i2++){
                if(text1.charAt(i1-1)==text2.charAt(i2-1)){
                    dp[i1][i2]=1+dp[i1-1][i2-1];
                }else{
                    dp[i1][i2]=Math.max(dp[i1-1][i2],dp[i1][i2-1]);
                }
                
            }
        }
        return dp[n][m];
    }
}
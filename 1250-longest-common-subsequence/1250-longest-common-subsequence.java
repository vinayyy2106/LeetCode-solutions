class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return lengthOfSequence(text1.length(),text2.length(),text1,text2,dp);
    }
    public int lengthOfSequence(int i1,int i2,String text1,String text2,int[][] dp){
        if(i1==0 || i2==0){
            return 0;
        }
        if(dp[i1][i2]!=-1)return dp[i1][i2];
        if(text1.charAt(i1-1)==text2.charAt(i2-1)){
            return dp[i1][i2]=1+lengthOfSequence(i1-1,i2-1,text1,text2,dp);
        }
        return dp[i1][i2]=Math.max(lengthOfSequence(i1-1,i2,text1,text2,dp),lengthOfSequence(i1,i2-1,text1,text2,dp));
    }
}
class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        return noOfMatches(n-1,m-1,word1,word2,dp);
    }
    public int noOfMatches(int i1,int i2,String word1,String word2,int[][] dp){
        if(i1<0){
            return i2+1;
        }
        if(i2<0){
            return i1+1;
        }
        if(dp[i1][i2]!=-1)return dp[i1][i2];
        if(word1.charAt(i1)==word2.charAt(i2))return dp[i1][i2]=noOfMatches(i1-1,i2-1,word1,word2,dp);
        return dp[i1][i2]=Math.min(1+noOfMatches(i1,i2-1,word1,word2,dp),Math.min(1+noOfMatches(i1-1,i2,word1,word2,dp),1+noOfMatches(i1-1,i2-1,word1,word2,dp)));
    }
}
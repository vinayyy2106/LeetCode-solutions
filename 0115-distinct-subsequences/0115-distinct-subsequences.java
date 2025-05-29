class Solution {
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()+1][t.length()+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        return noOfMatches(s.length()-1,t.length()-1,s,t,dp);
    }
    public int noOfMatches(int i1,int i2,String s,String t,int[][] dp){
        if(i2<0)return 1;
        if(i1<0)return 0;
        if(dp[i1][i2]!=-1)return dp[i1][i2];
        if(s.charAt(i1)==t.charAt(i2))return dp[i1][i2]=noOfMatches(i1-1,i2-1,s,t,dp)+noOfMatches(i1-1,i2,s,t,dp);
        return dp[i1][i2]=noOfMatches(i1-1,i2,s,t,dp);
    }
}
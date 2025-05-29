class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        // for(int[] row:dp)Arrays.fill(row,-1);
        // return noOfMatches(s.length()-1,t.length()-1,s,t,dp);
        //tabulation
        //basecase
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=m;i++){
            dp[0][i]=0;
        }
        for(int i1=1;i1<=n;i1++){
            for(int i2=1;i2<=m;i2++){
                if(s.charAt(i1-1)==t.charAt(i2-1)) dp[i1][i2]=dp[i1-1][i2-1]+dp[i1-1][i2];
                else dp[i1][i2]=dp[i1-1][i2];
            }
        }
        return dp[n][m];
    }
    //memoization
    public int noOfMatches(int i1,int i2,String s,String t,int[][] dp){
        if(i2<0)return 1;
        if(i1<0)return 0;
        if(dp[i1][i2]!=-1)return dp[i1][i2];
        if(s.charAt(i1)==t.charAt(i2))return dp[i1][i2]=noOfMatches(i1-1,i2-1,s,t,dp)+noOfMatches(i1-1,i2,s,t,dp);
        return dp[i1][i2]=noOfMatches(i1-1,i2,s,t,dp);
    }
}
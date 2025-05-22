class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        return noOfPaths(dp.length-1,dp[0].length-1,dp);
    }
    public int noOfPaths(int i,int j,int[][] dp){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int up=noOfPaths(i-1,j,dp);
        int down=noOfPaths(i,j-1,dp);
        dp[i][j]=up+down;
        return dp[i][j];
    }
}
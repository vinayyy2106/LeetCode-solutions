class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        return noOfPaths(0,0,m-1,n-1,dp);
    }
    public int noOfPaths(int i,int j,int m,int n,int[][] dp){
        if(i==m && j==n)return 1;
        if(i>m || j>n)return 0;
        if(dp[i][j]!=0)return dp[i][j];
        int down=noOfPaths(i+1,j,m,n,dp);
        int right=noOfPaths(i,j+1,m,n,dp);
        return dp[i][j]=down+right;
    }
}
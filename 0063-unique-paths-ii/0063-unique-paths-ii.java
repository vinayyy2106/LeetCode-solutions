class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        return noOfPaths(obstacleGrid.length-1,obstacleGrid[0].length-1,dp,obstacleGrid);
    }
    public int noOfPaths(int i,int j,int[][] dp,int[][] ob){
        if(i<0 || j<0 || ob[i][j]==1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int up=noOfPaths(i-1,j,dp,ob);
        int down=noOfPaths(i,j-1,dp,ob);
        dp[i][j]=up+down;
        return dp[i][j];
    }
}
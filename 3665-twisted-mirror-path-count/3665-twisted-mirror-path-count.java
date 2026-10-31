class Solution {
    int m;
    int n;
    int[][] dp;
    int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        int ways=solve(grid,0,0);
        return ways%MOD;
    }
    public int solve(int[][] grid,int i,int j){
        if(i==m-1 && j==n-1)return 1;
        if(i<0 || j<0 || i>=m || j>=n)return 0;
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
        int count=0;
        int[] nextStep=step(grid,i,j,0);//0 right
        if(nextStep!=null)count=(count+solve(grid,nextStep[0],nextStep[1]))%MOD;
        nextStep=step(grid,i,j,1);//1 down
        if(nextStep!=null)count=(count+solve(grid,nextStep[0],nextStep[1]))%MOD;
        return dp[i][j]=count%MOD;
    }
    public int[] step(int[][] grid,int i,int j, int dir){
        int nexI= i+ (dir==0?0:1);
        int nexJ= j+ (dir==0?1:0);
        if(nexI==m-1 && nexJ==n-1)return new int[]{m-1,n-1};
        while(nexI>=0 && nexJ>=0 && nexI<m && nexJ<n && grid[nexI][nexJ]==1){
            if(dir!=0){
                nexJ++;
                dir=0;
            }else{
                nexI++;
                dir=1;
            }
        }
        return new int[]{nexI,nexJ};
    }
}
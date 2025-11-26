class Solution {
    int mod = 1_000_000_007;
    public int numberOfPaths(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m+1][n+1][k+1];
        for(int i=0;i<k;i++){
            dp[m-1][n-1][i]=((i+grid[m-1][n-1])%k==0) ? 1 :0;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                for(int rem=0;rem<k;rem++){
                    if (i == m - 1 && j == n - 1)
                        continue;
                    int newRem=(rem + grid[i][j]) % k;
                    long down  = dp[i + 1][j][newRem];
                    long right = dp[i][j + 1][newRem];

                    dp[i][j][rem] = (int)((down + right) % mod);
                }
            }
        }
        return dp[0][0][0];
    }
}
class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int sum=0;
        for(int pile:piles){
            sum+=pile;
        }
        int[][] dp=new int[n][n];
        for(int[] arr:dp)Arrays.fill(arr,-1);
        int aliceScore=solve(0,n-1,piles,dp);
        return aliceScore>sum/2;
    }
    public int solve(int i,int j,int[] piles,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int take_i=piles[i]+Math.min(solve(i+2,j,piles,dp),solve(i+1,j-1,piles,dp));
        int take_j=piles[j]+Math.min(solve(i+1,j-1,piles,dp),solve(i,j-2,piles,dp));
        return dp[i][j]=Math.max(take_i,take_j);
    }
}
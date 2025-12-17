class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n=prices.length;
        long[][][] dp=new long[n+1][k+1][3];
         for (int i = 0; i <=n; i++)
            for (int j = 0; j <= k; j++)
                for (int l = 0; l < 3; l++)
                    dp[i][j][l] = Long.MIN_VALUE;
        return solve(0,k,0,prices,dp);
    }
    public long solve(int i,int k,int casee,int[] prices,long[][][] dp){
        if(i==prices.length){
            if(casee==0)return 0;
            return Long.MIN_VALUE/2;
        }
        if(dp[i][k][casee]!=Long.MIN_VALUE)return dp[i][k][casee];

        long dontTake=solve(i+1,k,casee,prices,dp);
        long take=Long.MIN_VALUE;
        if(k>0){
            if(casee==1){
                //sell it today -normal 
                take=prices[i]+solve(i+1,k-1,0,prices,dp);
            }else if(casee==2){
                //buy it today - shorting
                take=-prices[i]+solve(i+1,k-1,0,prices,dp);
            }else{
                //new transaction(cycle)
                take=Math.max(
                    -prices[i]+solve(i+1,k,1,prices,dp),//buy
                    prices[i]+solve(i+1,k,2,prices,dp)//short
                );
            }
        }
        return dp[i][k][casee]=Math.max(take,dontTake);
    }
}
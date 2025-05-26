class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int res= findCoins(coins.length-1,coins,dp,amount);
        return res==Integer.MAX_VALUE?-1:res;
    }
        public int findCoins(int n,int[] coins,int[][] dp,int amount){
            if (amount == 0) return 0;
            if(n==0){
                if(amount%coins[0]==0){
                    return amount/coins[0];
                }
                return Integer.MAX_VALUE;
            }
            if(dp[n][amount]!=-1){
                return dp[n][amount];
            }
            int notTaken=findCoins(n-1,coins,dp,amount);
            int taken=Integer.MAX_VALUE;
            // if(coins[n]<=amount){
            //     int subResult=findCoins(n,coins,dp,amount-coins[n]);
            //     if(subResult!=Integer.MAX_VALUE)taken=1+subResult;
            // }
             if (coins[n] <= amount) {
                int subResult = findCoins(n, coins, dp, amount - coins[n]);
                if (subResult != Integer.MAX_VALUE) {
                taken = 1 + subResult;
            }
          }
          return dp[n][amount]=Math.min(taken,notTaken);
        }
    
}
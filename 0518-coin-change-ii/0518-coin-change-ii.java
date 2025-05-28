class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        int n=coins.length;
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            for(int T=0;T<=amount;T++){
                int notTaken=dp[i-1][T];
                int taken=0;
                if(coins[i]<=T)taken=dp[i][T-coins[i]];
                dp[i][T]=taken+notTaken;
            }
        }
        return dp[n-1][amount];
    }
    public int noOfCombinations(int i,int[] coins,int[][] dp,int amount){
        
        if(i==0){
            if(amount%coins[i]==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[i][amount]!=-1)return dp[i][amount];
        int notTaken=noOfCombinations(i-1,coins,dp,amount);
        int taken=0;
        if(coins[i]<=amount)taken=noOfCombinations(i,coins,dp,amount-coins[i]);
        return dp[i][amount]=taken+notTaken;
    }
}
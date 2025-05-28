class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return noOfCombinations(coins.length-1,coins,dp,amount);
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
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length; 
        int[] dp=new int[n];
        
        for(int i=0;i<n;i++){
            if(i==0 || i==1){
                dp[i]=cost[i];
            }else{
                dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
            }
        }
        return Math.min(dp[n-1],dp[n-2]);
        // int[] dp2=new int[n];
        // Arrays.fill(dp1,-1);
        // Arrays.fill(dp2,-1);
        // return Math.min(minCost(n - 1, cost,dp1), minCost(n - 2, cost,dp2));
    }
    public int minCost(int n,int[] cost,int[] dp){
        if(n==1 || n==0)return cost[n];
        if(dp[n]!=-1)return dp[n];
        return dp[n]=cost[n]+Math.min(minCost(n-1,cost,dp),minCost(n-2,cost,dp));
    }
}
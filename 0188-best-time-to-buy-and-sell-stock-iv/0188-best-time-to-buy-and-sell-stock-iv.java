class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProf(prices,n,k,dp,1,0);
    }
    public int maxProf(int[] prices,int n,int max,int[][][] dp,int buy,int ind){
        if(max==0){
            return 0;
        }
        if(ind==n){
            return 0;
        }
        if(dp[ind][buy][max]!=-1){
            return dp[ind][buy][max];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max((-1)*prices[ind] + maxProf(prices,n,max,dp,0,ind+1),0+maxProf(prices,n,max,dp,1,ind+1));
        }
        if(buy==0){
            profit=Math.max(prices[ind] + maxProf(prices,n,max-1,dp,1,ind+1),0+maxProf(prices,n,max,dp,0,ind+1));
        }
        dp[ind][buy][max]=profit;
        return dp[ind][buy][max];
    }
}
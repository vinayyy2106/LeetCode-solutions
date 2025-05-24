class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    int profit=0;
                    if(buy==1){
                        profit=Math.max((-1)*prices[ind] + dp[ind+1][0][cap],0+dp[ind+1][1][cap]);
                    }
                    if(buy==0){
                        profit=Math.max(prices[ind] + dp[ind+1][1][cap-1],0+dp[ind+1][0][cap]);
                    }
                    dp[ind][buy][cap]=profit;
        
                }
            }
        }
        return dp[0][1][2];
    }
    //memoization
    public int maxProfit(int[] prices,int n,int max,int[][][] dp,int buy,int ind){
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
            profit=Math.max((-1)*prices[ind] + maxProfit(prices,n,max,dp,0,ind+1),0+maxProfit(prices,n,max,dp,1,ind+1));
        }
        if(buy==0){
            profit=Math.max(prices[ind] + maxProfit(prices,n,max-1,dp,1,ind+1),0+maxProfit(prices,n,max,dp,0,ind+1));
        }
        dp[ind][buy][max]=profit;
        return dp[ind][buy][max];
    }
}
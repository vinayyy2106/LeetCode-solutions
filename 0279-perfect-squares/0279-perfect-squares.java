class Solution {
    public int numSquares(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    public int helper(int n,int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            min=Math.min(min,1+helper(n-i*i,dp));
        }
        return dp[n]=min;
    }
}
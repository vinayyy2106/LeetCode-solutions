class Solution {
    final int MOD = 1_000_000_007;
    public int numberOfWays(int n, int x) {
        int[][] dp=new int[302][302];
        for(int[] arr:dp)Arrays.fill(arr,-1);
        return helper(n,1,x,dp);
    }
    public int helper(int n,int num,int x,int[][] dp){
        if(n==0)return 1;
        // if (num > n) return 0;
        int powValue=(int)Math.pow(num,x);
        if(dp[n][num]!=-1)return dp[n][num];
        
        if(powValue>n)return 0;
        int takeNum=helper(n-powValue,num+1,x,dp);
        int skipNum=helper(n,num+1,x,dp);
        return dp[n][num]=(int)((takeNum + skipNum) % MOD);
    }
}
class Solution {
    public int minScoreTriangulation(int[] values) {
        //Matrix chain multiplication - but easy intuition
        int n=values.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,n-1,values,dp);
    }
    public int solve(int i,int j,int[] values,int[][] dp){
        if(j-i+1<3)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int val=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int wt=values[i]*values[j]*values[k]+solve(i,k,values,dp)+solve(k,j,values,dp);
            val=Math.min(val,wt);
        }
        return dp[i][j]=val;
    }
}
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp=new double[query_row+1][query_glass+1];
        for(double[] arr:dp)Arrays.fill(arr,-1.0);
        return Math.min(1.0,solve(poured,query_row,query_glass,dp));
    }
    public double solve(int poured,int i,int j,double[][] dp){
        if(i<0 || j<0 || i<j)return 0;
        if(dp[i][j]!=-1.0)return dp[i][j];
        if(i==0 && j==0)return poured;
        double left=(solve(poured,i-1,j-1,dp)-1)/2.0;
        double right=(solve(poured,i-1,j,dp)-1)/2.0;
        if(left<0)left=0;
        if(right<0)right=0;
        return dp[i][j]=left+right;
    }
}
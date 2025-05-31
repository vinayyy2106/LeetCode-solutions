class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[] newCuts=new int[m+2];
        newCuts[0]=0;
        for(int i=0;i<m;i++){
            newCuts[i+1]=cuts[i];
        }
        newCuts[m+1]=n;
        Arrays.sort(newCuts);
        int[][] dp=new int[m+1][m+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        return minCost(1,m,newCuts,dp);
    }
    public int minCost(int i,int j,int[] newCuts,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int ans=newCuts[j+1]-newCuts[i-1]+minCost(i,k-1,newCuts,dp)+minCost(k+1,j,newCuts,dp);
            min=Math.min(min,ans);
        }
        return dp[i][j]=min;
    }
}
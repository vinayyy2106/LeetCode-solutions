class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        int[][][] dp=new int[m+1][n+1][len];
        for(int[][] arr:dp){
            for(int[] a:arr){
                Arrays.fill(a,-1);
            }
        }
        int[][] count=new int[len][2];//0,1-count
        for(int i=0;i<len;i++){
            for(char ch:strs[i].toCharArray()){
                if(ch=='0')count[i][0]++;
                else count[i][1]++;
            }
        }
        return solve(m,n,count,dp,0);
    }
    public int solve(int m,int n,int[][] count,int[][][] dp,int i){
        if(i>=count.length || (m==0 && n==0))return 0;
        if(dp[m][n][i]!=-1)return dp[m][n][i];
        int take=0;
        if(count[i][0]<=m && count[i][1]<=n){
            take=1+solve(m-count[i][0],n-count[i][1],count,dp,i+1);
        }
        int nottake=solve(m,n,count,dp,i+1);
        return dp[m][n][i]=Math.max(take,nottake);
    }
}
class Solution {
    int[] copies;
    int minPrice;
    int n;
    public int maximumSaleItems(int[][] items, int budget) {
        n=items.length;
        copies=new int[n];
        minPrice=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int copy=0;
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(items[j][0]%items[i][0] == 0)copy++;
            }
            minPrice=Math.min(minPrice,items[i][1]);
            copies[i]=copy;
        }
        int[][] dp=new int[n+1][budget+1];
        for(int[] arr:dp)Arrays.fill(arr,-1);
        return solve(n-1,items,budget,dp);
    }
    public int solve(int i,int[][] items, int budget,int[][] dp){
        if(i<0){
            return budget/minPrice;
        }
        if(dp[i][budget]!=-1)return dp[i][budget];
        int take=0;
        if(items[i][1]<=budget){
            take=1+copies[i]+solve(i-1,items,budget-items[i][1],dp);
        }
        int skip=solve(i-1,items,budget,dp);
        return dp[i][budget]=Math.max(take,skip);
    }
}
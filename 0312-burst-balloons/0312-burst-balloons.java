class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] newArr=new int[n+2];
        newArr[0]=1;
        for(int i=0;i<n;i++){
            newArr[i+1]=nums[i];
        }
        newArr[n+1]=1;
        int[][] dp=new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j)continue;
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int ans=dp[i][k-1]+dp[k+1][j]+newArr[i-1]*newArr[k]*newArr[j+1];
                    max=Math.max(max,ans);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n];
    }
    public int maxValue(int i,int j,int[] newArr,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int max=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int ans=maxValue(i,k-1,newArr,dp)+maxValue(k+1,j,newArr,dp)+newArr[i-1]*newArr[k]*newArr[j+1];
            max=Math.max(max,ans);
        }
        return dp[i][j]=max;
    }
}
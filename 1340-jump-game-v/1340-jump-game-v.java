class Solution {
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int[] dp=new int[n];
        int res=1;
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            res=Math.max(res,solve(i,arr,d,dp));
        }
        return res;
    }
    public int solve(int i,int[] arr,int d,int[] dp){
        if(dp[i]!=-1)return dp[i];
        int temp=1;
        for(int j=i+1;j<=Math.min(arr.length-1,i+d);j++){
            if(arr[j]<arr[i]){
                temp=Math.max(temp,1+solve(j,arr,d,dp));
            }else break;
        }
        for(int j=i-1;j>=Math.max(0,i-d);j--){
            if(arr[j]<arr[i]){
                temp=Math.max(temp,1+solve(j,arr,d,dp));
            }else break;
        }
        return dp[i]=temp;
    }
}
class Solution {
    int n;
    public int maximumJumps(int[] nums, int target) {
        n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int res=solve(0,target,nums,dp);
        if(res<0)return -1;
        return res;
    }
    public int solve(int i,int target,int[] nums,int[] dp){
        if(i==n-1)return dp[i]=0;
        if(dp[i]!=Integer.MIN_VALUE)return dp[i];
        int res=Integer.MIN_VALUE;
        for(int j=i+1;j<n;j++){
            
            if(Math.abs(nums[j]-nums[i])<=target){
                int temp=1+solve(j,target,nums,dp);
                res=Math.max(res,temp);
            }
        }
        return dp[i]=res;

    }
}
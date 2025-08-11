class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp=new int[21][21];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int playerOne=helper(0,nums.length-1,nums,dp);
        int sum=0;
        
        
        for(int n:nums){
            sum+=n;
        }
        return playerOne>=sum-playerOne;
    }
    public int helper(int i,int j,int[] nums,int[][] dp){
        if(i>j)return 0;
        if(i==j)return nums[i];
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int firstEle=nums[i]+(Math.min(helper(i+2,j,nums,dp),helper(i+1,j-1,nums,dp)));
        int secondEle=nums[j]+Math.min(helper(i+1,j-1,nums,dp),helper(i,j-2,nums,dp));
        return dp[i][j]=Math.max(firstEle,secondEle);
    }
}
class Solution {
    //nothing but no of subsets with total-target/2
    public int findTargetSumWays(int[] nums, int target) {
        int totSum=0;
        for(int i=0;i<nums.length;i++){
            totSum+=nums[i];
        }
        if(totSum<target || (totSum-target)%2!=0)return 0;
        int[][] dp=new int[nums.length][((totSum-target)/2)+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return noOfSubsets(nums.length-1,(totSum-target)/2,dp,nums);
    }
    public int noOfSubsets(int i,int target,int[][] dp,int[] nums){
        if(i==0){
            if(target==0 && nums[0]==0){
                return 2;//2 ways include 0/exclude 0
            }
            if(target==0 || nums[0]==target){
                return 1;
            }
            return 0;
        }
        if(dp[i][target]!=-1)return dp[i][target];
        int notTaken=noOfSubsets(i-1,target,dp,nums);
        int taken=0;
        if(target>=nums[i])taken=noOfSubsets(i-1,target-nums[i],dp,nums);
        return dp[i][target]=taken+notTaken;
       
    }
}
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int playerOne=helper(0,nums.length-1,nums);
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        return playerOne>=sum-playerOne;
    }
    public int helper(int i,int j,int[] nums){
        if(i>j)return 0;
        if(i==j)return nums[i];
        int firstEle=nums[i]+(Math.min(helper(i+2,j,nums),helper(i+1,j-1,nums)));
        int secondEle=nums[j]+Math.min(helper(i+1,j-1,nums),helper(i,j-2,nums));
        return Math.max(firstEle,secondEle);
    }
}
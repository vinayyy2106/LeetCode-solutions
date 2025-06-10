class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int marked=0;
        for(int i=0;i<n;i++){
            if(i>marked)return false;
            marked=Math.max(marked,nums[i]+i);
            if(marked>n)return true;
        }
        return true;
    }
}
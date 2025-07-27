class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=1;i<n-1;i++){
            if(nums[i]==nums[i-1])continue;
            int left=i-1;
            int right=i+1;
            while(left>=0 && nums[left]==nums[i]){
                left--;
            }
            while(right<n && nums[right]==nums[i]){
                right++;
            }
            if(left>=0 && right<n && nums[left]<nums[i] && nums[right]<nums[i]){
                count++;
            }
            if(left>=0 && right<n && nums[left]>nums[i] && nums[right]>nums[i]){
                count++;
            }
        }
        return count;
    }
}
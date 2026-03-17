class Solution {
    public int findMin(int[] nums) {
        int val=0;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if (nums[start] <= nums[end]) {
                return nums[start];
            }
            if(mid<end && nums[mid]>nums[mid+1])return nums[mid+1];
            if(mid>start && nums[mid]<nums[mid-1])return nums[mid];
            if(nums[start]<=nums[mid])start=mid+1;
            if(nums[end]>=nums[mid])end=mid;
        }
        return -1;
    }
}
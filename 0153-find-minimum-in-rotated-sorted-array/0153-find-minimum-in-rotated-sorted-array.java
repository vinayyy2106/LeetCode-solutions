class Solution {
    public int findMin(int[] nums) {
        int start=0;
            int end=nums.length-1;
            int val=0;
            while(start<=end){
                int mid=start+(end-start)/2;
                // if(mid>start && mid<end){
                    if(mid<end && nums[mid]>nums[mid+1]){
                        val=mid+1;
                    }
                    if( mid>start && nums[mid]<nums[mid-1]){
                        val=mid;
                    }
                // }
                if(nums[start]<=nums[mid]){
                    start=mid+1;
                }
                if(nums[end]>nums[mid]){
                    end=mid-1;
                }
            }
            return nums[val];
    }
}
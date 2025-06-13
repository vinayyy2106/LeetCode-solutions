class Solution {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(0,nums.length-2,nums);
    }
    public int binarySearch(int s,int e,int[] nums){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }else{
                if(nums[mid]==nums[mid-1]){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }

        }
        return nums[s];
    }

}
class Solution {
    public boolean check(int[] nums) {
        int prev=0;
        int n=nums.length;
        boolean dropped = false;
        for(int i=0;i<n-1;i++){
            if(nums[i]<=nums[i+1]){
                prev=nums[i];
                if(dropped && nums[i+1]>nums[0])return false;
            }
            else {
                if(dropped){
                    return false;
                }
                dropped=true;
            }
        }
        if (dropped && nums[n - 1] > nums[0]) {
            return false;
        }

        return true;
    }
}
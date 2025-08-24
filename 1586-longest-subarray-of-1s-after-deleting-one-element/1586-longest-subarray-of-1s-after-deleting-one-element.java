class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length==1)return 0;
        int i=0;
        int j=0;
        int last_zero_index=-1;
        int res=0;
        while(j<nums.length){
            if(nums[j]==0){
                i=last_zero_index+1;
                last_zero_index=j;
            }
            res=Math.max(res,j-i);
            j++;
        }
        return res;
    }
}
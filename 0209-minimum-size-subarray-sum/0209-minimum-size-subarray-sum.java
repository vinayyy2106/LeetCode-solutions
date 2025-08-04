class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int length=Integer.MAX_VALUE;
        int tot=0;
        while(j<nums.length){
            tot+=nums[j];
            if(tot>=target){
                length=Math.min(length,j-i+1);
                while(tot>=target){
                    tot-=nums[i];
                    i++;
                    if(tot>=target)length=Math.min(length,j-i+1);
                }
            }
            j++;
        }
        return length==Integer.MAX_VALUE?0:length;
    }
}
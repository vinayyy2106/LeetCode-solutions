class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int or=0;
            for(int j=i;j<n;j++){
                or|=nums[j];
                if(or>=k){
                    minLen=Math.min(j-i+1,minLen);
                }
            }
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
}
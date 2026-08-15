class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int xor=0;
        boolean hasNonZero=false;
        for(int i=0;i<n;i++){
            xor^=nums[i];
            if(nums[i]>0)hasNonZero=true;
        }
        return xor==0?(hasNonZero==true?n-1:0):n;
    }
}
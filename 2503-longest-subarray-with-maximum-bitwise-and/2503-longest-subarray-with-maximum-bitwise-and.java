class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int longest = 0, count = 0;
        for (int num : nums) {
            if (num == max) {
                count++;               
                longest = Math.max(longest, count);
            } else {
                count = 0;             
            }
        }
        return longest;
    }
    
    
    // public void helper(int i,int n,int xor,int[] nums,int val){
    //     if(i==n){
    //         if(val==xor){
    //             total=Math.max(total,i);
    //         }
    //         return;
    //     }
    //     helper(i+1,n,xor,nums,val|nums[i]);
    //     helper(i+1,n,xor,nums,val);
    // }
}
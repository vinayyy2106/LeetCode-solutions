class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int maxLen=0;
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[j]-nums[i]==1){
                maxLen=Math.max(j-i+1,maxLen);
                 j++;
           }else if(nums[j]-nums[i]==0){                
                j++;
            }else{
                i++;
                // j++;
            }
        }
        return maxLen;
    }
}
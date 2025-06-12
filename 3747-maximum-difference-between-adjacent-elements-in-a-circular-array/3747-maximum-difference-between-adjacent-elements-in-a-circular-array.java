class Solution {
    public int maxAdjacentDistance(int[] nums) {
        
        int i=0;
        int j=1;
        int n=nums.length;
        int diff=Math.abs(nums[n-1]-nums[0]);
        while(j!=n){
            diff=Math.max(Math.abs(nums[j]-nums[i]),diff);
            j++;
            i++;
        }
        
        return diff;
    }
}
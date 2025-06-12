class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int diff=0;
        int i=0;
        int j=1;
        int n=nums.length;
        while(j!=n){
            diff=Math.max(Math.abs(nums[j]-nums[i]),diff);
            j++;
            i++;
        }
        diff=Math.max(Math.abs(nums[i]-nums[0]),diff);
        return diff;
    }
}
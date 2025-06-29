class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int prod=1;
        int prod2=1;
        prod=prod*nums[0]*nums[1]*nums[nums.length-1];
        prod2=prod2*nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        return prod>=prod2?prod:prod2;
    }
}
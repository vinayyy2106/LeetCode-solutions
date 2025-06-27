class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // HashSet<Integer> set=new HashSet<nums>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int c=0;
        for(int j=0;j<nums.length;j++){
            if(set.contains(nums[j]+diff) && set.contains(nums[j]+2*diff)){
                c++;
            }
        }
        return c;
    }
}
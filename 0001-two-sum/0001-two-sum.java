class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(numberToIndex.containsKey(diff)){
                return new int[]{numberToIndex.get(diff),i};
            }
            numberToIndex.put(nums[i],i);
        }
        return null;
    }
}
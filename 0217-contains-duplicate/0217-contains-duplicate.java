class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(mp.containsKey(nums[i])){
                return true;
            }
            mp.put(nums[i],i);
        }
        return false;
    }
}
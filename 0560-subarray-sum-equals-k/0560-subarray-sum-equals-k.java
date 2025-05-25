class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int sum=0;
        int count=0;
        for(int num:nums){
            sum=sum+num;
            if(mp.containsKey(sum-k)){
                count+=mp.get(sum-k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
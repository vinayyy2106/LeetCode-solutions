class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int prefix=0;
        int count=0;
        for(int num:nums){
            prefix=(prefix+num)%k;
            if(prefix<0)prefix+=k;
            count+=mp.getOrDefault(prefix, 0);
            mp.put(prefix,mp.getOrDefault(prefix, 0)+1);
        }
        return count;
    }
}
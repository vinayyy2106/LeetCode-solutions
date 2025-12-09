class Solution {
    
    public int specialTriplets(int[] nums) {
        long MOD = 1_000_000_007;
        Map<Integer,Integer> left_map =new HashMap<>();
        Map<Integer,Integer> right_map=new HashMap<>();
        for(int num:nums){
            right_map.put(num, right_map.getOrDefault(num, 0) + 1);
        }
        long count=0;
        for(int num:nums){
            right_map.put(num,right_map.get(num) - 1);
            if(right_map.get(num)==0)right_map.remove(num);
            int twice = 2 * num;
            if(left_map.containsKey(twice) && right_map.containsKey(twice)){
                long L = left_map.get(twice);  
                long R = right_map.get(twice); 
                count = (count + (L * R) % MOD) % MOD;
            }
            left_map.put(num, left_map.getOrDefault(num, 0) + 1);
        }
        return (int) (count%MOD);
    }
}
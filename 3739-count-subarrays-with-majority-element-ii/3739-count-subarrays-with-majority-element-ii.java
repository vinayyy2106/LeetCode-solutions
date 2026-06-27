class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        int cumSum=0;
        mp.put(0,1);
        long validLeftPoints=0;
        long res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                validLeftPoints+=mp.getOrDefault(cumSum,0);
                cumSum+=1;
            }else{
                cumSum-=1;
                validLeftPoints-=mp.getOrDefault(cumSum,0);
            }
            mp.put(cumSum,mp.getOrDefault(cumSum,0)+1);
            res+=validLeftPoints;

        }
        return res;
    }
}
class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum=0;
        for(int num:nums){
            sum=(sum+num)%p;
        }
        int n=nums.length;
        int target=sum%p;
        if(target==0)return 0;
        Map<Integer,Integer> mp=new HashMap<>();// here we will store and update prev sum % p 
        mp.put(0,-1);
        int min=n;
        int curr=0;
        for(int i=0;i<n;i++){
            curr=(curr+nums[i])%p;
            int find=(curr-target+p)%p;
            if(mp.containsKey(find)==true){
                min=Math.min(min,i-mp.get(find));
            }
            mp.put(curr,i);
        }
        return min==n?-1:min;
    }
}
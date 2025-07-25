class Solution {
    public int maxSum(int[] nums) {
        if(nums.length==1)return nums[0];
        Map<Integer,Integer> mp=new HashMap<>();
        int sum=0;
        int n=nums.length;
        int maxNegative = Integer.MIN_VALUE;
        boolean hasAdded=false;
        for(int i=0;i<n;i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i],i);
                if(nums[i]>=0){
                    sum+=nums[i];
                    hasAdded=true;
                }else{
                    maxNegative=Math.max(maxNegative,nums[i]);
                }
            }
            
        }
        return hasAdded ? sum : maxNegative;
    }
}
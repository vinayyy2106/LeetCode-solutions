class Solution {
    public int rob(int[] nums) {
        int prev=0;
        int prev2=nums[0];
        for(int i=1;i<nums.length;i++){
            // if(i>1){
            //     int consider=nums[i]+prev;
            // }else{
            //     int consider=nums[i];
            // }
            int consider = nums[i];
            if (i > 1)
                consider += prev;
            int notConsider=0+prev2;
            int curr=Math.max(consider,notConsider);
            prev=prev2;
            prev2=curr;
        }

        return prev2;
    }
}
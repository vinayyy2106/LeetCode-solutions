class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int start=0;
        int end=nums.length;
        return Math.max(sum(nums,start,end-1),sum(nums,start+1,end));
    }
    public int sum(int[] nums,int start,int end){
        int prev=0;
        int prev2=nums[start];
        for(int i=start+1;i<end;i++){
            int consider = nums[i];
            if (i > 1 )
                consider += prev;
            int notConsider=prev2;
            int curr=Math.max(consider,notConsider);
            prev=prev2;
            prev2=curr;
        }

        return prev2;
    }
}
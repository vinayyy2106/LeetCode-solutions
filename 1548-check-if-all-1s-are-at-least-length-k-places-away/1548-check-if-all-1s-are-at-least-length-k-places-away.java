class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count=0;
        boolean firstOne=false;
        for(int i=0;i<nums.length;i++){
            if((i==0 && nums[i]==1) || (i>0 && nums[i]==1 && !firstOne) || (i>0 && nums[i]==0 && !firstOne)){
                firstOne=true;
            }else if(nums[i]!=1){
                count++;
            }
            else{
                if(count<k){
                    return false;
                }
                count=0;
            }
        }
        return true;
    }
}
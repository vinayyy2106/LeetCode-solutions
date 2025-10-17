class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int prod=1;
        int zeroes=0;
        int id=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroes++;
                id=i;
            }else{
                prod*=nums[i];
            }
        }
        if(zeroes==0){
            for(int i=0;i<n;i++){
                res[i]=prod/nums[i];
            }
        }else if(zeroes==1){
            res[id]=prod;
        }
        return res;
    }
}
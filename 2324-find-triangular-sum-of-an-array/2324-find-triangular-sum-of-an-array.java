class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int[] num=nums;
        while(n!=1){
            for(int i=0;i<n-1;i++){
                num[i]=(num[i]+num[i+1])%10;
            }
            n--;
        }
        return num[0];
    }
}
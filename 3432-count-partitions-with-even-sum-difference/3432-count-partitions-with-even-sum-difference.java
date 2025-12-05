class Solution {
    public int countPartitions(int[] nums) {
        int count=0;
        int sum=0;
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        for(int i=0;i<nums.length-1;i++){
            sum+=nums[i];
            if((totalSum-(2*sum))%2==0)count++;
        }
        return count;
    }
}
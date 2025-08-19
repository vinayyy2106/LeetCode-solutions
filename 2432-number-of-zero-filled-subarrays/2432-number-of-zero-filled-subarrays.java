class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long[] zeroArr=new long[nums.length];
        if(nums[0]==0)zeroArr[0]=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=0)continue;
            zeroArr[i]=zeroArr[i-1]+1;
        }
        long count=0;
        for(long num:zeroArr){
            count+=num;
        }
        return count;
    }
}
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long[] zeroArr=new long[nums.length];
        long count=0;
        if(nums[0]==0){
            zeroArr[0]=1;
            count=1;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=0)continue;
            zeroArr[i]=zeroArr[i-1]+1;
            count+=zeroArr[i];
        }
        
        // for(long num:zeroArr){
        //     count+=num;
        // }
        return count;
    }
}
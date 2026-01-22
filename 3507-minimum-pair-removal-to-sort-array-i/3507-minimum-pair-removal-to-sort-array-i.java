class Solution {
    public int minimumPairRemoval(int[] nums) {
        int ops=0;
        int n=nums.length;
        while(!isSorted(nums,n)){
            int min=Integer.MAX_VALUE;
            int pos=-1;
            ops++;
            for(int i=1;i<n;i++){
                int sum=nums[i]+nums[i-1];
                if(sum<min){
                    min=sum;
                    pos=i;
                }
            }
            nums[pos-1]=min;
            for(int i=pos;i<n-1;i++){
                nums[i]=nums[i+1];
                
            }
            n--;
        }
        return ops;
    }
    private boolean isSorted(int[]nums,int n){
        for(int i=1;i<n;i++)
            if(nums[i]<nums[i-1]){
                return false;
            }
        return true;
    }
}
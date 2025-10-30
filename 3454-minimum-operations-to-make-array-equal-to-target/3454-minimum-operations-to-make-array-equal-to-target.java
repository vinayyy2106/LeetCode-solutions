class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n=nums.length;
        // int[] diff=new int[n];
        // for(int i=0;i<n;i++){
        //     diff[i]=target[i]-nums[i];
        // }
        int prev=0;
        int curr=0;
        long result=0;
        for(int i=0;i<n;i++){
            curr=target[i]-nums[i];
            if((curr<0 && prev>0) || (curr>0 && prev <0)){
                result+=Math.abs(curr);
            }else if(Math.abs(curr)>Math.abs(prev)){
                result+=Math.abs(curr-prev);
            }
            prev=curr;
        }
        return result;
    }
}
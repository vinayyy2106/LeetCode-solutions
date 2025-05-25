class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }else{
            return checkTarget(nums,sum/2,nums.length);
        }
    }
    public boolean checkTarget(int[] nums,int sum,int n){
        boolean[] prev=new boolean[sum+1];
        prev[0]=true;
        if (nums[0] <= sum)prev[nums[0]]=true;
        for(int i=1;i<n;i++){
            boolean[] curr=new boolean[sum+1];
            curr[0]=true;
            for(int j=1;j<=sum;j++){
                boolean notTaken=prev[j];
                boolean taken=false;
                if(nums[i]<=j){
                    taken=prev[j-nums[i]];
                }
                curr[j]=notTaken||taken;
            }
            prev=curr;
        }
        return prev[sum];
    }
}
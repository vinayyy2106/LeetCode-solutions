class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int num:nums)sum+=num;
        if(sum%k!=0)return false;// I mean we are getting the sum to chcek what will the sum for each bucket sum/k
        Arrays.sort(nums);
        reverse(nums);
        boolean[] visited = new boolean[nums.length];
        return helper(0,sum/k,0,nums,k,0,visited);
    }
    public boolean helper(int i,int bucketSum,int currSum,int[] nums,int k,int buckets,boolean[] list){
        if(buckets==k-1)return true;//no need to chck fr last bucket
        if(bucketSum==currSum){
            return helper(0,bucketSum,0,nums,k,buckets+1,list);
        }
        if(i>=nums.length)return false;
        if(currSum>bucketSum)return false;
        if (list[i]) {
            return helper(i + 1, bucketSum, currSum, nums, k, buckets, list);
        } else {
        // Pick
            list[i] = true;
            if (helper(i + 1, bucketSum, currSum + nums[i], nums, k, buckets, list)) return true;
            list[i] = false;
        // Pruning:
        // If this is the first number in the bucket and it fails, no need to try others
            if (currSum == 0) return false;
        // If adding nums[i] exactly filled bucket but failed, skip further tries
            if (currSum + nums[i] == bucketSum) return false;
        }

    // Not pick
        return helper(i + 1, bucketSum, currSum, nums, k, buckets, list);
    }
    private void reverse(int[] nums) {
    for (int a = 0, b = nums.length - 1; a < b; a++, b--) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
}
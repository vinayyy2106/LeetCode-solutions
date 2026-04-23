class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long[] res=new long[n];
        Map<Integer,Long> indexCount=new HashMap<>();
        Map<Integer,Long> indexSum=new HashMap<>();
        for(int i=0;i<n;i++){
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum  = indexSum.getOrDefault(nums[i], 0L);
            res[i] += freq * i - sum;

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }
        indexSum.clear();
        indexCount.clear();
        for(int i=n-1;i>=0;i--){
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum  = indexSum.getOrDefault(nums[i], 0L);
            res[i] += sum-freq * i;

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }
        return res;
    }
}
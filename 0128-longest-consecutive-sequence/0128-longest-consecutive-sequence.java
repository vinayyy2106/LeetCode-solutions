class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int maxCount=1;
        int count=1;
        for(int ele:set){
            if(!set.contains(ele-1)){
                count=1;
                while(set.contains(ele+1)){
                    ele=ele+1;
                    count+=1;
                }
                maxCount=Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
}
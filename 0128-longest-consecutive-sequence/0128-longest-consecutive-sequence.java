class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int maxLen=0;
        int curr=-1;
        for(int num:set){
            int count=0;
            if(!set.contains(num-1)){
                count=1;
                curr=num;
            }
            while(set.contains(curr+1)){
                curr++;
                count++;
            }
            maxLen=Math.max(maxLen,count);
        }
        return maxLen;
    }
}
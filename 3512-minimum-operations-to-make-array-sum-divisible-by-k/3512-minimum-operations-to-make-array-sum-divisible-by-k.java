class Solution {
    public int minOperations(int[] nums, int k) {
        int count=0;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int num=sum%k;
        if(num==0)return count;
        return num;
    }
}
class Solution {
    public int minimumOperations(int[] nums) {
        int count=0;
        for(int num:nums){
            int val=num%3;
            if(val==0){
                continue;
            }else{
                count++;
            }
        }
        return count;
    }
}
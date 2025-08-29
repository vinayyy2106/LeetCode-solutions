class Solution {
    public int removeDuplicates(int[] nums) {
        int s=0;
        int e=0;
        while(e<nums.length){
            if(e==0 || e== 1){
                nums[s]=nums[e];
                s++;
                e++;
            }
            else if(nums[e]==nums[s-2]){
                e++;
            }
            else{
                nums[s]=nums[e];
                s++;
                e++;
            }
        }
        return s;
    }
}
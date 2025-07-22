class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l=0;
        int r=0;
        HashSet<Integer> uniqueDigits = new HashSet<>(); // to check uniqueness
        int sum=0;
        int n=nums.length;
        int max=0;
        while(r<n){
            if(uniqueDigits.contains(nums[r])){
                while(uniqueDigits.contains(nums[r])){
                    uniqueDigits.remove(nums[l]);
                    max-=nums[l];
                    l++;
                }
            }
            uniqueDigits.add(nums[r]);
            max+=nums[r];
            r++;
            sum=Math.max(sum,max);
        }
        return sum;
    }
}
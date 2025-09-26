class Solution {
    public int triangleNumber(int[] nums) {
        //for a triange to have 3 valid sides we need to check three conditions as we know
        //something which comes into mind once we see the prob is "two pointers"
        //sorting the array can make it easy bcz we can only check a+b>c 
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        for(int k=n-1;k>=2;k--){
            int i=0;
            int j=k-1;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                    count+=(j-i);// anything between i and j can also satisfy this bcz we have sorted in ascending order
                    j--;//reducing j
                }else{
                    i++;//incresing the side
                }
            }
        }
        return count;
    }
}
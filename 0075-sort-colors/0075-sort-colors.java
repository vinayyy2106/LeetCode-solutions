class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int[] count=new int[3];
        for(int i=0;i<n;i++){
            count[nums[i]]++;
        }
        int i=0;
        int j=0;
        while(i<3){
            while(count[i]>0){
                nums[j++]=i; 
                count[i]--;
            }
            i++;
        }   
    }
}
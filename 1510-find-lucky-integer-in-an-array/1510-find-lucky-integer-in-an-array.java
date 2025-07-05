class Solution {
    public int findLucky(int[] arr) {
        int num=0;
        for(int a:arr){
            num=Math.max(num,a);
        }
        int nums[]=new int[num+1];
        for(int a:arr){
            nums[a]++;
        }
        int j=-1;
        for(int i=1;i<nums.length;i++){
            if(i==nums[i]){
                j=Math.max(i,j);
            }
        }
        return j;
    }
}
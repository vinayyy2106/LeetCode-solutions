class Solution {
    public int matrixSum(int[][] nums) {
        for(int[] num:nums){
            Arrays.sort(num);
        }
        int score=0;
        int n=Integer.MIN_VALUE;
        int ele=nums[0].length-1;
        while(ele>=0){
            for(int[] num:nums){
                n=Math.max(n,num[ele]);
            }
            score+=n;
            n=Integer.MIN_VALUE;
            ele--;
        }
        return score;
    }
}
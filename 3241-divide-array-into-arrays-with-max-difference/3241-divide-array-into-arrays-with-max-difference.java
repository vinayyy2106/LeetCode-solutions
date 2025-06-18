class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int maxArray[]=new int[max+1];
        for(int num:nums){
            maxArray[num]++;
        }
        int row=0;
        int temp=0;
        int[][] res=new int[n/3][3];
        for(int i=1;i<=max;i++){
            while(maxArray[i]>0){
                if(temp==3){
                    temp=0;
                    if(Math.abs(res[row][2]-res[row][0])>k){
                        return new int[0][];
                    }
                    row++;
                }
                res[row][temp]=i;
                maxArray[i]--;
                temp++;
            }
        }
        if (temp == 3 && Math.abs(res[row][2] - res[row][0]) > k) {
        return new int[0][];
    }
        return res;
    }
}
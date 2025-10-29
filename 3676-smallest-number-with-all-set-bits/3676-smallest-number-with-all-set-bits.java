class Solution {
    public int smallestNumber(int n) {
        int[] nums={2,4,8,16,32,64,128,256,512,1024};
        for(int num:nums){
            if(num>n)return num-1;
        }
        return -1;
    }
}
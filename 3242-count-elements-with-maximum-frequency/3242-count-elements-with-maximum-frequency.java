class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr=new int[101];
        int max=Integer.MIN_VALUE;
        int res=0;
        for(int num:nums){
            arr[num]++;
            if(arr[num]>max){
                max=arr[num];
            }
        }
        for(int i=1;i<=100;i++){
            if(arr[i]==max){
                res+=max;
            }
        }
        return res;
    }
}
class Solution {
    public int maxProduct(int n) {
        int[] arr=new int[10];
        while(n>0){
            int temp=n%10;
            arr[temp]++;
            n=n/10;
        }
        int max1=0;
        int max2=0;
        for(int i=0;i<10;i++){
            if(arr[i]!=0)max1=Math.max(max1,i);
        }
        arr[max1]--;
        for(int i=0;i<10;i++){
            if(arr[i]!=0)max2=Math.max(max2,i);
        }
        return max1*max2;
    }
}
class Solution {
    public int[] sumZero(int n) {
        int[] arr=new int[n];
        if(n%2==1){
            arr[0]=0;
            int i=1;
            int num=1;
            while(i<n){
                arr[i]=num;;
                i++;
                arr[i]=num*-1;
                i++;
                num++;
            }
        }else{
            int i=0;
            int num=1;
            while(i<n){
                arr[i]=num;;
                i++;
                arr[i]=num*-1;
                i++;
                num++;
            }
        }
        return arr;

    }
}
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder t=new StringBuilder("");
        if(k==1){
            for(int i=1;i<=n;i++){
                t.append(Integer.toString(i));
            }
            return t.toString();
        }else{
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=i+1;
            }
            while(k!=1){
                nextPermutation(nums);
                k--;
            }
            for(int i=0;i<nums.length;i++){
                t.append(Integer.toString(nums[i]));
            }
            return t.toString();
        }
        
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int ind=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            reverseArray(0,n-1,nums);
        }else{
            for(int i=n-1;i>ind;i--){
                if(nums[i]>nums[ind]){
                    int temp=nums[i];
                    nums[i]=nums[ind];
                    nums[ind]=temp;
                    break;

                }
            }
            reverseArray(ind+1,n-1,nums);
        }
    }
    public void reverseArray(int i,int j,int[] arr){
        int m=j-i+1;
        for(int k=0;k<m/2;k++){
            int temp=arr[i+k];
            arr[i+k]=arr[j-k];
            arr[j-k]=temp;
        }
    }
}
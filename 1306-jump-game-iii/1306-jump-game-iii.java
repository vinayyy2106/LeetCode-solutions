class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean[] vis=new boolean[n];
        return helper(arr,start,n,vis);
    }
    public boolean helper(int[] arr,int i,int n,boolean[] vis){
        if(i<0 || i>n-1 || vis[i])return false;
        if(arr[i]==0)return true;
        vis[i]=true;
        return helper(arr,i+arr[i],n,vis) || helper(arr,i-arr[i],n,vis);
    }
}
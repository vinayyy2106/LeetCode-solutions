class Solution {
    int m,n;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        m=nums1.length;
        n=nums2.length;
        int[][] dp=new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,Integer.MIN_VALUE);
        }
        return solve(0,0,dp,nums1,nums2);
    }
    public int solve(int i,int j,int[][] dp,int[] nums1,int[] nums2){
        if(i==m || j==n)return Integer.MIN_VALUE;
        if(dp[i][j]!=Integer.MIN_VALUE)return dp[i][j];
        int val=nums1[i]*nums2[j];
        int nextValAndVal=val;
        int next=solve(i+1,j+1,dp,nums1,nums2);
        if(next!=Integer.MIN_VALUE){
            nextValAndVal=val+next;
        }
        int not_i=solve(i+1,j,dp,nums1,nums2);
        int not_j=solve(i,j+1,dp,nums1,nums2);
        return dp[i][j]=Math.max(val,Math.max(nextValAndVal,Math.max(not_i,not_j)));
    }
}
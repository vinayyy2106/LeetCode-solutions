class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int a=s1.length();
        int b=s2.length();
        if (a + b != s3.length()) return false;
        int[][] dp=new int[a+1][b+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,0,0,s1,s2,s3,dp);
    }
    public boolean helper(int i,int j,int k,String s1,String s2,String s3,int[][] dp){
        if(i==s1.length() && j==s2.length() && k==s3.length())return true;
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        boolean x=false;
        boolean y=false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            x=helper(i+1,j,k+1,s1,s2,s3,dp);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            y=helper(i,j+1,k+1,s1,s2,s3,dp);
        }
        dp[i][j]= (x||y)?1:0;
        return dp[i][j]==1;
    }
}
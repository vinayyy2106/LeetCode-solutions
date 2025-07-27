class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')return 0;
        int n=s.length();
        int[] dp=new int[101];
        Arrays.fill(dp,-1);
        return helper(0,s,dp,n);
    }
    public int helper(int i,String s,int[] dp,int n){
        if(i==n){
            return dp[i]=1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        if(s.charAt(i)=='0'){
            return dp[i]=0;
        }
        int pickOne=helper(i+1,s,dp,n);
        int pickTwo=0;
        if(i+1<n){
            String twoDigit = s.substring(i, i + 2);
            int val = Integer.parseInt(twoDigit);
            if (val >= 10 && val <= 26) {
                pickTwo = helper(i + 2, s, dp, n);
            }
        }
        return dp[i]=pickOne+pickTwo;
    }
}
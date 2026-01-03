class Solution {
    int M = 1_000_000_007;
    int[][] t;
    String[] states = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };
    public int numOfWays(int n) {
        t=new int[n][12];
        for(int[] arr:t){
            Arrays.fill(arr,-1);
        }
        int result=0;
        for(int i=0;i<12;i++){
            result= (result+solve(n-1,i,t)) % M;
        }
        return result;
    }
    public int solve(int n,int prev,int[][] dp){
        if(n==0)return 1;
        if(dp[n][prev]!=-1)return dp[n][prev];
        int result=0;
        String prevStr=states[prev];
        for(int i=0;i<12;i++){
            String currStr=states[i];
            boolean conflict=false;
            for(int j=0;j<3;j++){
                if(prevStr.charAt(j) == currStr.charAt(j)){
                    conflict=true;
                    break;
                }
            }
            if(conflict==false){
                result=(result+solve(n-1,i,dp)) % M;
            }
        }
        return dp[n][prev]=result;
    }
}
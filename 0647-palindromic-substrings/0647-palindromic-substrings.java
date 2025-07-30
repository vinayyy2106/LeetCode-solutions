class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        int[][] dp=new int[n][n];
        for(int[] arr:dp)Arrays.fill(arr,-1);
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(check(i,j,dp,s)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean check(int i,int j,int[][] dp,String s){
        if(i>=j){
            return true;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if(s.charAt(i)==s.charAt(j)){
            boolean val=check(i+1,j-1,dp,s);
            if(val==true){
                dp[i][j]=1;
            }else{
                dp[i][j]=0;
            }
            return val;
        }
        dp[i][j]=0;
        return false;
    }
}
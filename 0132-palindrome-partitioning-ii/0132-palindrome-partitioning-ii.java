class Solution {
    public int minCut(String s) {
        int n= s.length();
        int[] dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int k=i;k<n;k++){
                if(isPalindrome(i,k,s)){
                    int cost=1+minCount(k+1,n,dp,s);
                    min=Math.min(cost,min);
                }
            }
            dp[i]=min;
        }
        return dp[0]-1;
        // Arrays.fill(dp,-1);
        // return minCount(0,n,dp,s)-1;
    }
    public int minCount(int i,int n,int[] dp,String s){
        if(i==n)return 0;
        if (dp[i] != -1) return dp[i];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<n;k++){
            if(isPalindrome(i,k,s)){
                int cost=1+minCount(k+1,n,dp,s);
                min=Math.min(cost,min);
            }
        }
        return dp[i]=min;
    }
    public boolean isPalindrome(int i,int j,String str){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
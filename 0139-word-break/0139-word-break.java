class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))return true;
        int n=s.length();
        int[] dp=new int[301];
        Arrays.fill(dp, -1);
        Set<String> dict = new HashSet<>(wordDict);
        return helper(0,s,dp,n,dict);
    }
    public boolean helper(int ind,String s,int[] dp,int n,Set<String> wordDict){
        if(ind>=n){
            return true;
        }
        if(dp[ind]!=-1){
            return dp[ind]==1;
        }
        for(int i=ind;i<n;i++){
            String str=s.substring(ind,i+1);
            if(wordDict.contains(str) && helper(i+1,s,dp,n,wordDict)){
                dp[ind]=1;
                return true;
            }
        }
        dp[ind] = 0;
        return false;
    }
}
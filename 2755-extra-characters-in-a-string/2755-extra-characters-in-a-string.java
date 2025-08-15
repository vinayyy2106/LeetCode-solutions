class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp=new int[51];
        Arrays.fill(dp,-1);
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        // for(String str:dictionary)set.add(str);
        return helper(s,set,s.length(),0,dp);
    }
    public int helper(String s, Set<String> set,int n,int i,int[] dp){
        if(i>=n)return 0;
        if(dp[i]!=-1)return dp[i];
        String curr_string="";
        int minCharacters=n;
        for(int j=i;j<n;j++){
            curr_string+=s.charAt(j);
            int extraCharsToTake=0;
            if(!set.contains(curr_string)){
                extraCharsToTake=curr_string.length();
            }
            minCharacters=Math.min(minCharacters,extraCharsToTake+helper(s,set,n,j+1,dp));
        }
        return dp[i]=minCharacters;
    }
}
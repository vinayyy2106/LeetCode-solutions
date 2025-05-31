class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp=new int[words.length];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0;i<words.length;i++){
            for(int prev=0;prev<i;prev++){
                //words[i] length > words[prev]
                if(compare(words[i],words[prev]) && 1+dp[prev]>dp[i]){ 
                    dp[i]=1+dp[prev];
                }
            }
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
    //longer,shorter
    public boolean compare(String word1,String word2){
        if(word1.length()-word2.length()!=1)return false;
        int i=0;
        int j=0;
        boolean skipped=false;
        while(i<word1.length() && j<word2.length()){
            if(word1.charAt(i)==word2.charAt(j)){
                i++;
                j++;
            }else{
                if(skipped)return false;
                skipped=true;
                i++;
            }
        }
        return true;
    }
}
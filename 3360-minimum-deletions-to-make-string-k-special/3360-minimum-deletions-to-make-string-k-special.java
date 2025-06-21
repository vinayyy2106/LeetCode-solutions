class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        int ans=word.length();
        for(int minFr:freq){
            if(minFr==0)continue;
            int del=0;
            for(int f:freq){
                if(f<minFr){
                    del+=f;
                }else{
                    del+=Math.max(0,f-minFr-k);
                }
            }
            ans=Math.min(ans,del);
        }
        return ans;
    }
}
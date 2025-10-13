class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res=new ArrayList<>();
        res.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(isAnagram(words[i],words[i-1])){
                continue;
            }else{
                res.add(words[i]);
            }
        }
        return res;
    }
    public boolean isAnagram(String word1,String word2){
        int[] freq=new int[26];
        for(char ch:word1.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch:word2.toCharArray()){
            freq[ch-'a']--;
        }
        for(int fr:freq){
            if(fr!=0)return false;
        }
        return true;
    }
}
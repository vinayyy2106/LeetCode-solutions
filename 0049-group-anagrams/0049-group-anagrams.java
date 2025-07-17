class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp=new HashMap<>();
        for(String str:strs){
            String st=getFreqString(str);
            if(mp.containsKey(st)){
                mp.get(st).add(str);
            }else{
                List<String> li=new ArrayList<>();
                li.add(str);
                mp.put(st,li);
            }
        }
        List<List<String>> ans=new ArrayList<>(mp.values());
        return ans;
    }
    public String getFreqString(String str){
        char[] charArr=new char[26];
        for(char c:str.toCharArray()){
            charArr[c-'a']++;
        }
        StringBuilder s=new StringBuilder();
        for(int i=0;i<26;i++){
            if(charArr[i]>0){
                s.append((char)(i+'a'));
                s.append(charArr[i]);
            }
        }
        return s.toString();
    }
}
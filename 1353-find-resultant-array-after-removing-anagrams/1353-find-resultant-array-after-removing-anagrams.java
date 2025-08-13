class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list=new ArrayList<>();
        char[] prevArr=words[0].toCharArray();
        Arrays.sort(prevArr);
        String prev=new String(prevArr);
        list.add(words[0]);
        for(int i=1;i<words.length;i++){
            char[] charArray1=words[i].toCharArray();
            Arrays.sort(charArray1);
            String str1=new String(charArray1);
            if(!str1.equals(prev)){
                list.add(words[i]);
                prev=str1;
            }
        }
        return list;
    }
}
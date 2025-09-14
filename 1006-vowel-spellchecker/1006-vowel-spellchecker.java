class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>(Arrays.asList(wordlist));
        Map<String,String> lowerMap=new HashMap<>();
        Map<String,String> vowelMap=new HashMap<>();
        for(String word:wordlist){
            String wd=word.toLowerCase();
            lowerMap.putIfAbsent(wd,word);//for making the first occurance to be in the map
            String mask=convertToMask(wd);// "
            vowelMap.putIfAbsent(mask,word);
        }
        String[] res=new String[queries.length];
        int i=0;
        for(String wd:queries){
            if(set.contains(wd)){
                res[i]=wd;
            }else{
                String l=wd.toLowerCase();
                if(lowerMap.containsKey(l)){
                    res[i]=lowerMap.get(l);
                }else{
                    String maskQ = convertToMask(l);
                    if(vowelMap.containsKey(maskQ)){
                        res[i]=vowelMap.get(maskQ);
                    }else{
                        res[i]="";
                    }
                }
            }
            i++;
        }
        return res;
    }
    public String convertToMask(String wrd){
        StringBuilder sb=new StringBuilder("");
        for(char ch:wrd.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o'|| ch=='u'){
                sb.append("*");
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
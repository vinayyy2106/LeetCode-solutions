class Solution {
    public String sortVowels(String s) {
        StringBuilder str=new StringBuilder();
        List<Character> li=new ArrayList<>();
        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                li.add(ch);
            }
        }
        Collections.sort(li);
        int ind=0;
        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                str.append(li.get(ind));
                ind++;
            }else{
                str.append(ch);
            }
        }
        return str.toString();
    }
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
            return true;
        }
        return false;
    }
}
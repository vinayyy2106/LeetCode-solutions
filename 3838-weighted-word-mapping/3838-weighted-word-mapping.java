class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str=new StringBuilder("");
        for(String word:words){
            int sum=0;
            for(int i=0;i<word.length();i++){
                sum+=weights[word.charAt(i)-97];
            }
            int mod=sum%26;
            char ch=(char)('z'-mod);
            str.append(ch);
        }
        return str.toString();
    }
}
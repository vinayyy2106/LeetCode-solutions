class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)return false;
        boolean vowel=false;
        boolean consonant=false;
        for(char ch:word.toCharArray()){
            if(Character.isLetter(ch)){
                ch=Character.toLowerCase(ch);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    vowel=true;
                }else{
                    consonant=true;
                }
            }else if(Character.isDigit(ch)){
                continue;
            }else{
                return false;
            }
        }
        return vowel && consonant;
    }
}
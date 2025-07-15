class Solution {
    public boolean isValid(String word) {
        Set<Character> charSet1 = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o','u'));
        if(word.length()<3)return false;
        boolean vowel=false;
        boolean consonant=false;
        for(char ch:word.toCharArray()){
            if(Character.isLetter(ch)){
                ch=Character.toLowerCase(ch);
                if(charSet1.contains(ch)){
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
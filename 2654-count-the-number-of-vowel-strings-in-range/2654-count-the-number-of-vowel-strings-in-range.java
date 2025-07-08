class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int cnt=0;
       
        for(int i=left;i<=right;i++){
            if(vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length()-1))){
                cnt++;
            }
        }
        return cnt;
    }
}
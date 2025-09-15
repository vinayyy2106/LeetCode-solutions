class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr=text.split(" ");
        Set<Character> broken = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            broken.add(c);
        }
        int count=0;
        for(String str:arr){
            boolean valid=true;
            for(char ch:str.toCharArray()){
                if(broken.contains(ch)){
                    valid=false;
                    break;
                }
            }
            if(valid)count++;
        }
        return count;
    }
}
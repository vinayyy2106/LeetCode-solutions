class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str=new StringBuilder();
        int c=0;
        for(int i=0;i<s.length();i++){
            if(c < spaces.length && i==0 && i==spaces[c]){
                c++;
                str.append(" ");
                str.append(s.charAt(i));
            }else if(c < spaces.length && i==spaces[c]){
                str.append(" ");
                str.append(s.charAt(i));
                c++;
            }else{
                str.append(s.charAt(i));
            }
            if(c==spaces.length){
                str.append(s.substring(i+1,s.length()));
                break;
            }
        }
        return str.toString();
    }
}
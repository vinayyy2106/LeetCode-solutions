class Solution {
    public String smallestSubsequence(String s) {
        boolean[] taken=new boolean[26];
        StringBuilder str=new StringBuilder();
        int[] last=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int idx=ch-'a';
            if(taken[idx]==true){
                continue;
            }
            while(str.length()>0 && str.charAt(str.length()-1)>ch && last[str.charAt(str.length()-1)-'a']>i){
                taken[str.charAt(str.length()-1)-'a']=false;
                str.deleteCharAt(str.length()-1);
            }
            str.append(ch);
            taken[ch-'a']=true;
        }
        return str.toString();
    }
}
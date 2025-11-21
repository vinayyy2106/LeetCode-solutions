class Solution {
    public int countPalindromicSubsequence(String s) {
        int n= s.length();
        Set<Character> st=new HashSet<>();
        for(int i=0;i<n;i++)st.add(s.charAt(i));
        int res=0;
        for(char ch:st){
            int first_ind=-1;
            int last_ind=-1;
            for(int i=0;i<n;i++){
                if (s.charAt(i) == ch) {
                    if (first_ind == -1) first_ind = i;
                    last_ind = i;
                }
            }
            Set<Character> temp=new HashSet<>();
            for(int i=first_ind+1;i<last_ind;i++){
                temp.add(s.charAt(i));
            }
            res+=temp.size();
        }
        return res;
    }
}
class Solution {
    public int minFlips(String s) {
        int n=s.length();
        String st=s+s;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for(int i=0;i<2*n;i++){
            s1.append(i%2==0?'0':"1");
            s2.append(i%2==0?'1':"0");
        }
        int res=Integer.MAX_VALUE;
        int flip1=0;
        int flip2=0;
        int l=0;
        for(int r=0;r<2*n;r++){
            if(st.charAt(r)!=s1.charAt(r))flip1++;
            if(st.charAt(r)!=s2.charAt(r))flip2++;
            if(r-l+1>n){
                if(st.charAt(l)!=s1.charAt(l))flip1--;
                if(st.charAt(l)!=s2.charAt(l))flip2--;
                l++;
            }
            if(r-l+1==n){
                res=Math.min(res,Math.min(flip1,flip2));
            }
        }
        return res;
    }
}
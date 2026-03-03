class Solution {
    public char findKthBit(int n, int k) {
        String s1="0";
        String a=findNthString(n,2,s1);
        return a.charAt(k-1);
    }
    static String findNthString(int n,int k,String s1){
        if(k>n){
            return s1;
        }
        StringBuilder inv=findInverted(s1);
        return findNthString(n,k+1,s1+1+inv);

    }
    static StringBuilder findInverted(String oldS){
        StringBuilder res1=new StringBuilder();
        for(int i=0;i<oldS.length();i++){
            res1=res1.append((char)((oldS.charAt(i)-'0')^1 + '0'));
        }
        return res1.reverse();
    }
    
}
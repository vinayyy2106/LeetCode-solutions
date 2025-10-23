class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder str=new StringBuilder(s);
        while(str.length()!=2){
            int n=str.length();
            StringBuilder new_str=new StringBuilder("");
            for(int i=0;i<n-1;i++){
                int digit_1=str.charAt(i)-'0';
                int digit_2=str.charAt(i+1)-'0';
                int mod=(digit_1+digit_2)%10;
                new_str.append((char)(mod+'0'));
            }
            str=new_str;
        }
        return str.charAt(0)==str.charAt(1);
    }
}
class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        int n=s.length();
        int result=0;
        int num=0;
        int sign=1;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if(c=='+'){
                result+=sign*num;
                sign=1;
                num=0;
            }
            else if(c=='-'){
                result+=sign*num;
                num=0;
                sign=-1;
            }
            else if(c=='('){
                st.push(result);
                st.push(sign);
                result=0;
                num=0;
                sign=1;
            }
            else if(c==')'){
                result+=sign*num;
                num=0;
                int top=st.pop();
                result*=top;
                top=st.pop();
                result+=top;
            }
        }
        result+=(sign*num);
        return result;
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String str:tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int a=st.pop();
                int b=st.pop();
                int val=str.equals("+")?b+a:str.equals("-")?b-a:str.equals("*")?b*a:b/a;
                st.push(val);
            }else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.peek();
    }
}
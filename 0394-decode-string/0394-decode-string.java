class Solution {
    public String decodeString(String s) {
        Stack<String> st=new Stack<>();
        Stack<Integer> sn=new Stack<>();
        int k=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                k=k*10+(ch-'0');
                continue;
            }
            if(ch=='['){
                sn.push(k);
                k=0;
                st.push(String.valueOf(ch));
                continue;
            }
            if(ch!=']'){
                st.push(String.valueOf(ch));
                continue;
            }
            StringBuilder temp = new StringBuilder();
            while (!st.peek().equals("["))
                temp.insert(0, st.pop());
            st.pop();
            StringBuilder replacement = new StringBuilder();
            int num=sn.pop();
            for(int i=0;i<num;i++){
                replacement.append(temp);
            }
            st.push(replacement.toString());
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            res.insert(0,st.pop());
        }
        return res.toString();
    }
}
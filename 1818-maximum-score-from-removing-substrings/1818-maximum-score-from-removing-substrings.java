class Solution {
    private int res=0;
    public int maximumGain(String s, int x, int y) { 
        if(x<y){
            String st=helper1(s,y);
            String st1=helper2(st,x);
        }else{
            String st=helper2(s,x);
            String st1=helper1(st,y);
        }
        return res;
    }
    public String helper1(String s,int y){
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(st.isEmpty()){
                st.push(ch);
                continue;
            }
            if(ch=='a' && st.peek()=='b'){
                res+=y;
                st.pop();
                continue;
            }
            
            st.push(ch);
        }
        StringBuilder str=new StringBuilder();
        while(!st.isEmpty()){
            str.insert(0,st.pop());
        }
        return str.toString();
    }
    public String helper2(String s,int x){
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(st.isEmpty()){
                st.push(ch);
                continue;
            }
            if(ch=='b' && st.peek()=='a'){
                res+=x;
                st.pop();
                continue;
            }
            st.push(ch);
        }
        StringBuilder str=new StringBuilder();
        while(!st.isEmpty()){
            str.insert(0,st.pop());
        }
        return str.toString();
    }
}
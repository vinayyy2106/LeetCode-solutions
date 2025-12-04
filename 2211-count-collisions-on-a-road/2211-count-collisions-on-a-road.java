class Solution {
    public int countCollisions(String directions) {
        int collisions=0;
        int n=directions.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            char ch=directions.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
            }else{
                if(ch=='L'){
                    if(st.peek()=='R'){
                        collisions+=2;
                        st.pop();
                        while (!st.isEmpty() && st.peek() == 'R') {
                            st.pop();
                            collisions += 1;
                        }
                        st.push('S');
                    }else if(st.peek()=='S'){
                        collisions+=1;
                    }else{
                        st.push(ch);
                    }
                }else if(ch=='R'){
                    st.push(ch);
                }else{
                    while (!st.isEmpty() && st.peek() == 'R') {
                        st.pop();
                        collisions += 1;
                    }
                    st.push('S');
                }
            }
        }
        return collisions;
    }
}
class MinStack {
    Stack<Long> st=new Stack<>();
    Long min=Long.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        Long x=(long)val;
        if(st.isEmpty()){
            st.push(x);
            min=x;
        }else{
            if(x>min){
                st.push(x);
            }else{
                st.push(2*x-min);
                min=x;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        long n=st.pop();
        if(n<min){
            min=2*min-n;
        }
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        if(st.peek()<min){
            return min.intValue();
        }else{
            Long n=st.peek();
            return n.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
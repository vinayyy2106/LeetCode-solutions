class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q= new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q.add(x);
        int size=q.size();
        for(int i=0;i<size-1;i++){
            int val=q.remove();
            q.add(val);
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        if(!q.isEmpty()){
            return false;
        }
        return true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
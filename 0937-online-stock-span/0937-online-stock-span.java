class StockSpanner {
    Stack<pair> st=new Stack<>();
    int ind =-1;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        ind+=1;
        while(!st.isEmpty() && st.peek().price<=price){
            st.pop();
        }
        int ans=ind-(st.isEmpty()? -1 : st.peek().index);
        st.push(new pair(price,ind));
        return ans;
    }
}
class pair{
    int price;
    int index;
    public pair(int price,int index){
        this.price=price;
        this.index=index;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
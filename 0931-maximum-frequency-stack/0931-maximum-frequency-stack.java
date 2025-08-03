class FreqStack {
    PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]==b[1]?b[2]-a[2]:b[1]-a[1]));
    int order=0;
    Map<Integer,Integer> mp=new HashMap<>();
    public FreqStack() {
        
    }
    public void push(int val) {
        mp.put(val,mp.getOrDefault(val,0)+1);
        pq.offer(new int[]{val,mp.get(val),this.order++});
    }
    public int pop() {
        int[] arr=pq.poll();
        int freq=mp.get(arr[0]);
        freq--;
        mp.put(arr[0],freq);
        return arr[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
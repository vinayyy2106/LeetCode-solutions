class LRUCache {
    int capacity;
    Map<Integer,Node> mp=new HashMap<>();
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        head.prev=null;
        tail.next=null;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }
            Node nd=mp.get(key);
            remove(nd);
            insert(nd);
        return nd.val;

    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            remove(mp.get(key));
        }
        if(mp.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    public void insert(Node nd){
        mp.put(nd.key,nd);
        nd.next=head.next;
        // head.next.prev=nd;
        nd.next.prev=nd;
        head.next=nd;
        nd.prev=head;
    }
    public void remove(Node nd){
        mp.remove(nd.key);
        nd.prev.next=nd.next;
        nd.next.prev=nd.prev;
    }
}
class Node{
    Node next;
    Node prev;
    int key;
    int val;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
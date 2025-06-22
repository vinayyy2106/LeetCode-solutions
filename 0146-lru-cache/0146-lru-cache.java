class LRUCache {
    Map<Integer,Node> mp=new HashMap<>();
    int capacity;
    Node head=new Node(0,-1);
    Node tail=new Node(0,-1);
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        head.prev=null;
        tail.prev=head;
        tail.next=null;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }else{
            Node nd=mp.get(key);
            remove(nd);
            insert(nd);
            return nd.val;
        }
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
    public void remove(Node node){
        mp.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void insert(Node node){
        mp.put(node.key,node);
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }
}
class Node{
    Node prev;
    Node next;
    int key;
    int val;
    Node(int key,int val){
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
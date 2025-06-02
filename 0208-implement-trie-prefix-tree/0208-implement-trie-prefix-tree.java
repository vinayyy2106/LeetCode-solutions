class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    // O(Length of word)
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            //moving to next ref trie as it was found/new one is created
            node=node.get(word.charAt(i));
        }
        node.updateFlag();
    }
    
    public boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node=node.get(word.charAt(i));
        }
        return node.isEnd()==true;
    }
    
    public boolean startsWith(String prefix) {
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node=node.get(prefix.charAt(i));
        }
        return true;
    }
}
class Node{
    Node[] links;
    boolean flag=false;
    public Node(){
        links=new Node[26];
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public void put(char ch,Node node){
        links[ch-'a']=node;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public void updateFlag(){
        flag=true;
    }
    public boolean isEnd(){
        return flag==true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
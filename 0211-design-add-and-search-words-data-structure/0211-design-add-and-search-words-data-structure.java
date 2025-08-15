class WordDictionary {
    Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node=node.getNext(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
        
    }
    public boolean dfs(String word,int i,Node node){
        if (node == null) return false;
        if (i == word.length()) return node.isEnd();
        char ch = word.charAt(i);
        if(ch=='.'){
            for(Node child:node.links){
                if(child!=null && dfs(word,i+1,child))return true;
            }
            return false;
        }else{
            return dfs(word,i+1,node.getNext(ch));
        }
    }
}
class Node{
    Node[] links=new Node[26];
    boolean flag=false;
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public void put(char ch,Node nd){
        links[ch-'a']=nd;
    }
    public Node getNext(char ch){
        return links[ch-'a'];
    }
    public void setEnd(){
        flag=true;
    }
    public boolean isEnd(){
        return flag;
    }
    public Node checkNext(){
        for(Node link:links){
            if(link!=null)return link;
        }
        return null;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
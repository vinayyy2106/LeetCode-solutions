// class Solution {
//     Map<String,List<String>> graph = new HashMap();
//     List<String> result = new ArrayList();
//     int numTickets = 0;
//     public List<String> findItinerary(List<List<String>> tickets) {
//         numTickets=tickets.size();
//         for(List<String> list:tickets){
//             graph.put(list.get(0),new ArrayList<String>());
//         }
//         //adj list
//         for(List<String> list:tickets){
//             graph.get(list.get(0)).add(list.get(1));
//         }
//         for(Map.Entry<String,List<String>> entry:graph.entrySet()){
//             Collections.sort(entry.getValue());
//         }
//         List<String> path=new ArrayList<>();
//         boolean isIt=helper("JFK",path);
//         return result;
//     }
//     public boolean helper(String start,List<String> path){
//         path.add(start);
//         if(path.size()==numTickets+1){
//             result=new ArrayList<>(path);
//             return true;
//         }
//         List<String> neighbors = graph.get(start);
//         for(int i=0;i<neighbors.size();i++){
//             String to=neighbors.remove(i);
//             if(helper(to,path)){
//                 return true;
//             }
//             neighbors.add(i,to);
//         }
//         path.remove(path.size()-1);
//         return false;
//     }
// }
// class Solution {
//     Map<String,PriorityQueue<String>> graph = new HashMap();
//     List<String> result = new ArrayList();
//     int numTickets = 0;
//     public List<String> findItinerary(List<List<String>> tickets) {
//         numTickets = tickets.size();
//         // for(List<String> ticket:tickets){
//         //     graph.put(ticket.get(0),new ArrayList());
//         // }
//         // for(List<String> ticket:tickets){
//         //     graph.get(ticket.get(0)).add(ticket.get(1));
//         // }
//         // for(Map.Entry<String,List<String>> edges:graph.entrySet()){
//         //     Collections.sort(edges.getValue());
//         // }
//         for(List<String> ticket:tickets) {
//             String source = ticket.get(0), dest = ticket.get(1);
//             if(!graph.containsKey(source))
//                 graph.put(source, new PriorityQueue<>());
//             graph.get(source).add(dest);
//         }
//         List<String> path = new ArrayList();
//         DFS("JFK",path);
        
//         return result;
//     }
    
//     public boolean DFS(String fromAirport,List<String> path){
//         path.add(fromAirport);
//         if(path.size() == numTickets+1){
//             result = path;
//             return true;
//         }
        
//         PriorityQueue<String> neighbors = graph.get(fromAirport);
//         while(!neighbors.isEmpty()){
//             String toAirport = neighbors.poll();
//             // neighbors.remove(toAirport);
//             if(DFS(toAirport,path)){
//                 return true;
//             }
//             neighbors.add(toAirport);
//         }
//         path.remove(path.size()-1);
//         return false;
//     }
// }
class Solution {
    List<String> ans = new ArrayList<>();
    void dfs(HashMap<String, PriorityQueue<String>> mp, String src) {
        
        PriorityQueue<String> pq = mp.get(src);
        while(pq!=null && !pq.isEmpty()){
            dfs(mp, pq.poll());
        }
        ans.add(src);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> mp = new HashMap<>();

        //push cities in hashmap
        for(List<String> ticket:tickets) {
            String source = ticket.get(0), dest = ticket.get(1);
            if(!mp.containsKey(source))
                mp.put(source, new PriorityQueue<>());
            mp.get(source).add(dest);
        }
        dfs(mp, "JFK");
        Collections.reverse(ans);
        return ans;
    }
}

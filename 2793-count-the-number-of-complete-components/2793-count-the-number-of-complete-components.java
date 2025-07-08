class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        int[] visited=new int[n];
        int closed=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                Queue<Integer> q = new LinkedList<>();
                List<Integer> componentNodes = new ArrayList<>();
                q.offer(i);
                int edgeCount=0;
                visited[i]=1;
                while(!q.isEmpty()){
                    int ele=q.poll();
                    componentNodes.add(ele);
                    for(int adjNode:list.get(ele)){
                        edgeCount++;
                        if(visited[adjNode]==0){
                            q.offer(adjNode);
                            visited[adjNode]=1;
                        }
                    }
                }
                
                int size=componentNodes.size();
                if(edgeCount/2==size*(size-1)/2){
                    closed++;
                }
            }
        }
        return closed;
    }
}
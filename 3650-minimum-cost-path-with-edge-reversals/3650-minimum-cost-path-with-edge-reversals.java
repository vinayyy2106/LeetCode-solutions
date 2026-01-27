class Solution {
    public int minCost(int n, int[][] edges) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, wt));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, 2 * wt));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.dist-b.dist));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int nd=p.node;
            int wt=p.dist;
            if(dist[nd]<wt)continue;
            if(nd==n-1)return dist[nd];
            if(adj.get(nd)==null)continue;
            for(Pair ent:adj.get(nd)){
                int newWt=wt+ent.dist;
                int newNode=ent.node;
                if(newWt<dist[newNode]){
                    dist[newNode]=newWt;
                    pq.offer(new Pair(newNode,newWt));
                }
            }
        }
        return -1;
    }
    
}
class Pair{
    int node;
    int dist;
    public Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
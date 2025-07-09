class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});//node,price
        }
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,src,0});//stops,startNode,price
        int[] price=new int[n];
        for(int i=0;i<n;i++){
            price[i]=(int)1e9;
        }
        price[src]=0;
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int stops=arr[0];
            int node=arr[1];
            int pri=arr[2];
            if(stops>k)continue;
            for(int[] neighbours:adj.get(node)){
                int nnode=neighbours[0];
                int wt=neighbours[1];
                if(pri+wt<price[nnode]){
                    price[nnode]=pri+wt;
                    q.add(new int[]{stops+1,nnode,pri+wt});
                }
            }
        }
        
        if(price[dst]!=(int) 1e9){
            return price[dst];
        }
        return -1;
    }
}
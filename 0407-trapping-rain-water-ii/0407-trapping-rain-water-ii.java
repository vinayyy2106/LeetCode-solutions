class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        int n=heightMap[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            pq.offer(new int[]{heightMap[i][0],i,0});
            vis[i][0]=true;
            pq.offer(new int[]{heightMap[i][n-1],i,n-1});
            vis[i][n-1]=true;
        }
        for(int i=0;i<n;i++){
            pq.offer(new int[]{heightMap[0][i],0,i});
            vis[0][i]=true;
            pq.offer(new int[]{heightMap[m-1][i],m-1,i});
            vis[m-1][i]=true;
        }
        int water=0;
        int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
        while(!pq.isEmpty()){
            int[] cell=pq.poll();
            int ht=cell[0];
            int i=cell[1];
            int j=cell[2];
            for(int[] dir:directions){
                int i_=i+dir[0];
                int j_=j+dir[1];
                if(i_>=0 && j_>=0 && i_<m && j_<n && !vis[i_][j_]){
                    water+=Math.max(ht-heightMap[i_][j_],0);
                    pq.offer(new int[]{Math.max(ht,heightMap[i_][j_]),i_,j_});
                    // pq.offer(new int[]{Math.max(heightMap[i][j],heightMap[i_][j_]),i_,j_});
                    vis[i_][j_]=true;
                }
            }
        }
        return water;
    }
}
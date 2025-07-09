class Solution {
    boolean isValid(int row, int col, int n, int m) {
        
        if (row < 0 || row >= n) return false;
        if (col < 0 || col >= m) return false;
        return true;
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] effortArr=new int[n][m];
        for(int[] arr:effortArr){
            Arrays.fill(arr,(int)1e9);
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);//int[0] is distance diff
        pq.offer(new int[]{0,0,0});
        effortArr[0][0]=0;
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            int dist=temp[0];
            int row=temp[1];
            int col=temp[2];
            if (row == n - 1 && col == m - 1) return dist;
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                if(isValid(nrow,ncol,n,m)){
                    int absDiff=Math.abs(heights[nrow][ncol]-heights[row][col]);
                    if(Math.max(absDiff,dist)<effortArr[nrow][ncol]){
                        effortArr[nrow][ncol]=Math.max(absDiff,dist);
                        pq.add(new int[]{Math.max(absDiff,dist),nrow,ncol});
                    }
                }
                
            }
        }
        return effortArr[n-1][m-1];
    }
}
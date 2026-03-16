class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;
        image[sr][sc]=color;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int row=arr[0];
            int col=arr[1];
            for(int i=0;i<4;i++){
                int newRow=row+delRow[i];
                int newCol=col+delCol[i];
                if(newRow>=0 && newRow<image.length && newCol>=0 && newCol<image[0].length && image[newRow][newCol]==originalColor){
                    image[newRow][newCol]=color;
                    q.add(new int[]{newRow,newCol});
                }
            }
        }
        return image;
    }
}
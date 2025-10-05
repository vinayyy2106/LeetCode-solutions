class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;
        boolean[][] pacific=new boolean[row][col];
        boolean[][] atlantic=new boolean[row][col];
        int[] delRow={-1,0,1,0};
        int[] delCol={0,+1,0,-1};
        for(int i=0;i<row;i++){
            dfs(Integer.MIN_VALUE,i,0,heights,pacific,row,col,delRow,delCol);
            dfs(Integer.MIN_VALUE,i,col-1,heights,atlantic,row,col,delRow,delCol);
        }
        for(int i=0;i<col;i++){
            dfs(Integer.MIN_VALUE,0,i,heights,pacific,row,col,delRow,delCol);
            dfs(Integer.MIN_VALUE,row-1,i,heights,atlantic,row,col,delRow,delCol);
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        return list;
    }
    public void dfs(int prev,int i,int j,int[][] heights,boolean[][] arr,int row,int col,int[] delRow,int[] delCol){
        if(i<0 || j<0 || i>= row || j>=col || heights[i][j]<prev || arr[i][j]){
            return;
        }
        arr[i][j]=true;
        for(int k=0;k<4;k++){
            int nrow=delRow[k]+i;
            int ncol=delCol[k]+j;
            dfs(heights[i][j],nrow,ncol,heights,arr,row,col,delRow,delCol);
        }
    }
}
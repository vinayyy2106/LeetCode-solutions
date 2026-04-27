class Solution {
    
    private boolean[][] visited;
    int n,m;
    private int[][] grid;
    private Map<Integer, List<Direction>> directions;
    public boolean hasValidPath(int[][] grid) {
        directions = Map.of(
            1, List.of(new Direction(0, -1, List.of(1, 4, 6)), new Direction(0, 1, List.of(1, 3, 5))),
            2, List.of(new Direction(-1, 0, List.of(2, 3, 4)), new Direction(1, 0, List.of(2, 5, 6))),
            3, List.of(new Direction(0, -1, List.of(1, 4, 6)), new Direction(1, 0, List.of(2, 5, 6))),
            4, List.of(new Direction(0, 1, List.of(1, 3, 5)), new Direction(1, 0, List.of(2, 5, 6))),
            5, List.of(new Direction(0, -1, List.of(1, 4, 6)), new Direction(-1, 0, List.of(2, 3, 4))),
            6, List.of(new Direction(0, 1, List.of(1, 3, 5)), new Direction(-1, 0, List.of(2, 3, 4)))
        );
        this.grid=grid;
        n=grid.length;
        m=grid[0].length;
        visited=new boolean[n][m];
        return dfs(0,0);
    }
    public boolean dfs(int i,int j){
        visited[i][j]=true;
        if(i==n-1 && j==m-1)return true;
        for(Direction dir:directions.get(grid[i][j])){
            int nextRow=i+dir.di;
            int nextCol=j+dir.dj;
            if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m && !visited[nextRow][nextCol] && dir.reachable.contains(grid[nextRow][nextCol]) && dfs(nextRow,nextCol)){
                return true;
            }
        }
        return false;
    } 
}
class Direction {
    int di;
    int dj;
    List<Integer> reachable;
    Direction(int di,int dj,List<Integer> reachable){
        this.di=di;
        this.dj=dj;
        this.reachable=reachable;
    }
}      

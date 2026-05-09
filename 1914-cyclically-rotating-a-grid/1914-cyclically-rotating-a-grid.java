class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int l=Math.min(m,n)/2;
        for(int i=0;i<l;i++){
            int top=i;
            int bottom=m-i-1;
            int left=i;
            int right=n-i-1;
            List<Integer> li=new ArrayList<>();
            for(int j=left;j<=right;j++){
                li.add(grid[top][j]);
            }
            for(int j=top+1;j<=bottom-1;j++){
                li.add(grid[j][right]);
            }
            for(int j=right;j>=left;j--){
                li.add(grid[bottom][j]);
            }
            for(int j=bottom-1;j>=top+1;j--){
                li.add(grid[j][left]);
            }
            int len = li.size();
            int normalizedK = k % len;
            Collections.rotate(li, -normalizedK);
            int idx = 0;
            for(int j=left;j<=right;j++){
    grid[top][j] = li.get(idx);
    idx++;
}

for(int j=top+1;j<=bottom-1;j++){
    grid[j][right] = li.get(idx);
    idx++;
}

for(int j=right;j>=left;j--){
    grid[bottom][j] = li.get(idx);
    idx++;
}

for(int j=bottom-1;j>=top+1;j--){
    grid[j][left] = li.get(idx);
    idx++;
}
        }
        return grid;
    }
}
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, int[]> yToMinMaxX = new HashMap<>();
        Map<Integer, int[]> xToMinMaxY = new HashMap<>();
        int count=0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            yToMinMaxX.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            xToMinMaxY.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});

            int[] xr = yToMinMaxX.get(y);
            xr[0] = Math.min(xr[0], x);
            xr[1] = Math.max(xr[1], x);

            int[] yr = xToMinMaxY.get(x);
            yr[0] = Math.min(yr[0], y);
            yr[1] = Math.max(yr[1], y);
        }
        for(int[] building:buildings){
            int x=building[0];
            int y=building[1];

            int[] xr=yToMinMaxX.get(y);
            int[] yr=xToMinMaxY.get(x);
            
            if(x>xr[0] && x<xr[1] && y>yr[0] && y<yr[1])count++;
        }
        return count;
    }
}
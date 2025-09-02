class Solution {
    public int numberOfPairs(int[][] points) {
        int n=points.length;
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // y descending
            }
            return a[0] - b[0];     // x ascending
        });
        int count=0;
        for(int i=0;i<n;i++){
            int min=Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                if(points[i][1]>=points[j][1] && points[j][1]>min){
                    count++;
                    min=points[j][1];
                }
            }
        }
        return count;
    }
}
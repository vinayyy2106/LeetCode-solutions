class Solution {
    public double largestTriangleArea(int[][] points) {
        double area=0;
        int n=points.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    double a= 0.5*Math.abs((points[i][0]*(points[j][1]-points[k][1]))+(points[j][0])*(points[k][1]-points[i][1])+(points[k][0])*(points[i][1]-points[j][1]));
                    area=Math.max(a,area);
                }
            }
        }
        return area;
    }
}
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int countNegatives=0;
        int minVal=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int val=matrix[i][j];
                if(val<0){
                    countNegatives++;
                }
                minVal=Math.min(minVal,Math.abs(val));
                sum+=Math.abs(val);
            }
        }
        if(countNegatives%2==0)return sum;
        return sum-2*minVal;
    }
}
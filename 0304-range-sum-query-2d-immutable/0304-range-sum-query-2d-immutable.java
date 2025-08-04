class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=1;i<n;i++){
            matrix[i][0]=matrix[i-1][0]+matrix[i][0];
        }
        for(int i=1;i<m;i++){
            matrix[0][i]=matrix[0][i-1]+matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                matrix[i][j]=matrix[i][j]+matrix[i-1][j]+matrix[i][j-1]-matrix[i-1][j-1];//prefix sum
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int del=0;
        if(row1!=0)del+=matrix[row1-1][col2];
        if(col1!=0)del+=matrix[row2][col1-1];
        if(row1!=0 && col1!=0)del-=matrix[row1-1][col1-1];
        return (matrix[row2][col2]-del);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
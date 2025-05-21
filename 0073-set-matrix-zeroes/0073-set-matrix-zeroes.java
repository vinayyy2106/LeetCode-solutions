class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int colo=1;
        //considering row 0 and col 0 itself as indicators
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j>0){
                        matrix[0][j]=0;
                    }else{
                        colo=0;
                    }
                }
            }
        }
        //do not disturb the markedd columns firstly
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]!=0){
                    if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
                }
                
            }
        }
        //now doing it for rest elements that is we never argeted matrix[0][0] and we need to do colums elements bcz changing wise rows will effect the matrix 1st column
        if(matrix[0][0]==0){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        if(colo==0){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
    }
}
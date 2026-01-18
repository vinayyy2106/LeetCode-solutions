class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] rowPrefSum=new int[m][n];
        int[][] colPrefSum=new int[m][n];
        for(int i=0;i<m;i++){
            rowPrefSum[i][0]=grid[i][0];
            for(int j=1;j<n;j++){
                rowPrefSum[i][j]=rowPrefSum[i][j-1]+grid[i][j];
            }
        }
        for(int i=0;i<n;i++){
            colPrefSum[0][i]=grid[0][i];
            for(int j=1;j<m;j++){
                colPrefSum[j][i]=colPrefSum[j-1][i]+grid[j][i];
            }
        }
        for(int side=Math.min(m,n);side>1;side--){
            for(int i=0;i+side-1<m;i++){
                for(int j=0;j+side-1<n;j++){
                    int targetSum=rowPrefSum[i][j+side-1]-(j>0?rowPrefSum[i][j-1]:0);
                    boolean allSame=true;
                    for(int r=i+1;r<i+side;r++){
                        int rowSum=rowPrefSum[r][j+side-1]-(j>0?rowPrefSum[r][j-1]:0);
                        if(rowSum!=targetSum){
                            allSame=false;
                            break;
                        }
                    }
                    if(!allSame)continue;
                    for(int c=j;c<j+side;c++){
                        int colSum=colPrefSum[i+side-1][c]-(i>0?colPrefSum[i-1][c]:0);
                        if(colSum!=targetSum){
                            allSame=false;
                            break;
                        }
                    }
                    if(!allSame)continue;
                    //check cols
                    int diag=0;
                    int antiDiag=0;
                    for(int k=0;k<side;k++){
                        diag+=grid[i+k][j+k];
                        antiDiag+=grid[i+k][j+side-1-k];
                    }
                    if(diag==targetSum && antiDiag==targetSum)return side;// no need to go beyong as me are starting from maximum possible side itself
                }
            }
        }
        return 1;
    }
}
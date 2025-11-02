class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] charArr=new char[m][n];
        for(int[] arr:guards){
            charArr[arr[0]][arr[1]]='G';
        }
        for(int[] arr:walls){
            charArr[arr[0]][arr[1]]='W';
        }
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}}; 
        for(int[] arr:guards){
            for(int[] d:dirs){
                int nrow=arr[0]+d[0];
                int ncol=arr[1]+d[1];
                while(nrow>=0 && nrow<m && ncol>=0 && ncol<n && charArr[nrow][ncol]!='G'&& charArr[nrow][ncol]!='W' ){
                    if(charArr[nrow][ncol]=='\0')charArr[nrow][ncol]='V';
                    
                    nrow+=d[0];
                    ncol+=d[1];
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(charArr[i][j]=='\0'){
                    count++;
                }
            }
        }
        return count;
    }
}
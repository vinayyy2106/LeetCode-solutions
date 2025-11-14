class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res=new int[n][n];
        for(int[] arr:queries){
            for(int i=arr[0];i<=arr[2];i++){
                for(int j=arr[1];j<=arr[3];j++){
                    res[i][j]++;
                }
            }
        }
        return res;
    }
}
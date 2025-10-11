class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int[] arr=new int[n*n+1];
        int[] res=new int[2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[grid[i][j]]==0){
                    arr[grid[i][j]]++;
                    continue;
                }else{
                    res[0]=grid[i][j];
                }
                
            }
        }
        for(int i=1;i<=n*n;i++){
            if(arr[i]==0){
                res[1]=i;
                break;
            }
            
        }
        return res;
    }
}
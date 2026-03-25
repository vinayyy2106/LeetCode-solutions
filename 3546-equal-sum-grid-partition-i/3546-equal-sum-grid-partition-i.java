class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum=0;
        int n=grid.length;
        int m=grid[0].length;
        long[] rowPref=new long[n];
        long[] colPref=new long[m];
        for(int i=0;i<n;i++){
            long rowSum=0;
            for(int j=0;j<m;j++){
                sum+=grid[i][j];
                rowSum+=grid[i][j];
            }
            rowPref[i]=rowSum;
        }
        if (sum % 2 != 0) return false;

        for(int i=0;i<m;i++){
            long colSum=0;
            for(int j=0;j<n;j++){
                // sum+=grid[][j];
                colSum+=grid[j][i];
            }
            colPref[i]=colSum;
        }
        long check=sum/2;
        long curr=0;
        for(int i=0;i<n-1;i++){
            curr+=rowPref[i];
            if(curr==check)return true;
        }
        curr=0;
        for(int i=0;i<m-1;i++){
            curr+=colPref[i];
            if(curr==check)return true;
        }
        return false;
    }
}
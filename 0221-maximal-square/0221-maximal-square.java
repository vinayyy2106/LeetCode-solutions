class Solution {
    public int maximalSquare(char[][] matrix) {
        int max=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[matrix.length][matrix[0].length];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){        
                    if (matrix[i][j] == '1') {
                        if(i==0 || j==0){
                            dp[i][j]=1;
                        }else{
                            
                        dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                        
                        }
                         max=Math.max(max,dp[i][j]);
                    }
                   
            }
        }
        return max*max;
    }
    public int helper(int i,int j,int n,int m,int[][] dp,char[][] matrix){
        if(i>=n || j>=m || matrix[i][j]=='0')return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        return dp[i][j]=1+Math.min(helper(i,j+1,n,m,dp,matrix),Math.min(helper(i+1,j+1,n,m,dp,matrix),helper(i+1,j,n,m,dp,matrix)));
    }
}
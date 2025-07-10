class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] floydDis=new int[n][n];
        for(int[] row:floydDis){
            Arrays.fill(row,(int)1e9);
        }
        for(int[] edge:edges){
            floydDis[edge[0]][edge[1]]=edge[2];
            floydDis[edge[1]][edge[0]]=edge[2];
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    floydDis[i][j]=Math.min(floydDis[i][k]+floydDis[k][j],floydDis[i][j]);
                }
            }
        }
        int minCount=(int)1e9;
        int ans=-1;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j && floydDis[i][j]<=distanceThreshold){
                    count++;
                }
                
            }
            if(count<minCount){
                    ans=i;
                    minCount=count;
                }else if(count==minCount){
                    ans=i;
                }
        }
        return ans;
    }
}
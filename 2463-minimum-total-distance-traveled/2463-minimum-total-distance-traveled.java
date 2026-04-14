class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        int m=robot.size();
        List<Integer> pos=new ArrayList<>();
        for(int[] f:factory){
            int limit=f[1];
            int po=f[0];
            for(int i=0;i<limit;i++){
                pos.add(po);
            }
        }
        int n=pos.size();
        long[][] dp=new long[m+1][n+1];
        for(long[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,robot,pos,dp);
    }
    public long solve(int i,int j,List<Integer> robots,List<Integer> pos,long[][] dp){
        if(i>=robots.size())return 0;
        if(j>=pos.size())return (long)1e12;
        if(dp[i][j]!=-1)return dp[i][j];

        long take=Math.abs(robots.get(i)-pos.get(j))+solve(i+1,j+1,robots,pos,dp);

        long donttake=0+solve(i,j+1,robots,pos,dp);
        return dp[i][j]=Math.min(take,donttake);
    }
}
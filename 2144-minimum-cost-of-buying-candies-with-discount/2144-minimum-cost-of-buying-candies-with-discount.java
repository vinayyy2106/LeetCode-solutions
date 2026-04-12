class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n=cost.length;
        int buy=0;
        if(n==1)return cost[0];
        if(n==2)return cost[0]+cost[1];
        for(int i=n-1;i>=0;i--){
            buy+=cost[i];
        }
        for(int i=n-3;i>=0;i-=3){
            buy-=cost[i];
        }
        return buy;
    }
}
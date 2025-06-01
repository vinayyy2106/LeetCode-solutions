class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<profit.length;i++){
            List<Integer> up=new ArrayList<>();
            up.add(startTime[i]);
            up.add(endTime[i]);
            up.add(profit[i]);
            list.add(up);
        }
        list.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        int[] dp=new int[profit.length+1];
        Arrays.fill(dp,-1);
        return maxProfit(0,dp,list,profit.length);//startindex,prevEndTime,dp,list,n
    }
    public int maxProfit(int i,int[] dp,List<List<Integer>> list,int n){
        if(i>=n)return 0;
        if(dp[i]!=-1)return dp[i];
        int notTake=0+maxProfit(i+1,dp,list,n);
        // int take=0;
        // if(list.get(i).get(0)>=j){}
        //     take=list.get(i).get(2)+maxProfit(i+1,list.get(i).get(1),dp,list,n);

         int next = findNext(list, list.get(i).get(1)); // Find next index
        int take = list.get(i).get(2) + maxProfit(next, dp,list, n);
        return dp[i]=Math.max(take,notTake);
    }
    private int findNext(List<List<Integer>> list, int currEndTime) {
    int low = 0, high = list.size() - 1;
    int ans = list.size();
    while (low <= high) {
        int mid = (low + high) / 2;
        if (list.get(mid).get(0) >= currEndTime) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}
}
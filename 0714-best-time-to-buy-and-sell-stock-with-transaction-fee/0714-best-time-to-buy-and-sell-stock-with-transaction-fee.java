class Solution {
    public int maxProfit(int[] prices, int fee) {
         int n=prices.length;
        int[] prev = new int[2];
        for(int i=n-1;i>=0;i--){
            int[] current = new int[2];
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                
                    if(buy==1){
                        profit=Math.max((-1)*prices[i]+prev[0],0+prev[1]);
                    }else{
                        profit=Math.max((prices[i]-fee)+prev[1],prev[0]);
                    }
                   current[buy]=profit;
               
                
            }
            prev=current;
        }
        return prev[1];
    }
}
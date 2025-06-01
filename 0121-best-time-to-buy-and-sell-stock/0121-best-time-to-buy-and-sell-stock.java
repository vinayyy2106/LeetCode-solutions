class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int start=prices[0];
        for(int i=1;i<prices.length;i++){
            profit=Math.max(prices[i]-start,profit);
            start=Math.min(start,prices[i]);
        }
        return profit;
    }
}
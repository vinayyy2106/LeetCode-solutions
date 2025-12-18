class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        long actualProfit=0;
        long[] profit=new long[n];
        for(int i=0;i<n;i++){
            profit[i]=(long)prices[i]*strategy[i];
            actualProfit+=profit[i];
        }
        long modifiedWinProfit=0;
        long originalWinProfit=0;
        long max_gain=0;
        int i=0,j=0;
        while(j<n){
            originalWinProfit+=profit[j];
            if(j-i+1 > k/2){
                modifiedWinProfit+=prices[j];
            }
            if(j-i+1>k){
                originalWinProfit -= profit[i];
                modifiedWinProfit -= prices[i + k / 2];
                i++;
            }
            if(j-i+1==k){
                max_gain=Math.max(max_gain,modifiedWinProfit-originalWinProfit);
            }
            j++;
        }
        return actualProfit+max_gain;
    }
}
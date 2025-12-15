class Solution {
    public long getDescentPeriods(int[] prices) {
        
        int n=prices.length;
        long ans=n;
        int i=0,j=1;
        while(j<n && i<n){
            if(prices[j]-prices[i]==-1){
                int ind=i;
                while(j<n && i<n && prices[j]-prices[i]==-1){
                    j++;
                    i++;
                }
                int len=i-ind+1;
                ans += (long) len * (len - 1) / 2;
            }else{
                j++;
                i++;
            }
        }
        return ans;
    }
}
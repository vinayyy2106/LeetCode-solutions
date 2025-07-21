class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=Integer.MIN_VALUE;
        for(int val:piles){
            min=Math.max(min,val);
        }
        int l=1;
        int r=min;
        int max=min;
        while(l<=r){
            int mid=l+(r-l)/2;
            int val=helper(piles,mid);
            if(val<=h){
                max=mid;
                r=mid-1; 
            }else{
                l=mid+1;
            }
        }
        return max;
    }
    public int helper(int[] piles,int perHr){
        int total=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            total+=Math.ceil((double)piles[i]/perHr);
        }
        return total;
    }
}
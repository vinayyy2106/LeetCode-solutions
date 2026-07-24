class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int ans=1;
        int n=nums.length;
        if(n==1 || n==2)return n;
        while(ans<=n){
            ans=ans*2;
        }
        return ans;
    }
}
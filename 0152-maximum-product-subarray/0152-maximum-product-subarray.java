class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int pref=1;
        int suff=1;
        int prod=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(pref==0)pref=1;
            if(suff==0)suff=1;
            pref*=nums[i];
            suff*=nums[n-1-i];
            prod=Math.max(prod,Math.max(pref,suff));
        }
        return prod;
    }
}
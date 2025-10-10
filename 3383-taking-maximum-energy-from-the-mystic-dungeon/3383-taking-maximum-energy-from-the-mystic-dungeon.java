class Solution {
    public int maximumEnergy(int[] energy, int k) {
        // int ene=0;
        int n=energy.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int maxEnergy=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxEnergy=Math.max(maxEnergy,getNextEnergy(i,k,energy,dp));
        }
        return maxEnergy;
    }
    public int getNextEnergy(int i,int k,int[] energy,int[] dp){
        if(i>energy.length-1)return 0;
        if(dp[i]!=Integer.MIN_VALUE)return dp[i];
        int next=getNextEnergy(i+k,k,energy,dp);
        return dp[i]=energy[i]+next;
    }
}
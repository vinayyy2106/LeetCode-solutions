class Solution {
    public int countPermutations(int[] complexity) {
        long MOD = 1_000_000_007;
        int n=complexity.length;
        long result = 1L;
        for(int i=1;i<n;i++){
            if(complexity[i]<=complexity[0]){
                return 0;
            }
            result=(result * i) % MOD; // As answer was (n-1)! as at every palce we have the chance of having each element which comes after it in org. array..
        }
        return (int) (result % MOD);
    }
}
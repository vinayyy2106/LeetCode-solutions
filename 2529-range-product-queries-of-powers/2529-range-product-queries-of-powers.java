import java.math.BigInteger;
class Solution {
    private long modPow(long base, long exp, long mod) {
    long result = 1;
    base %= mod;
    while (exp > 0) {
        if ((exp & 1) == 1) result = (result * base) % mod;
        base = (base * base) % mod;
        exp >>= 1;
    }
    return result;
}

    public int[] productQueries(int n, int[][] queries) {
        final long MOD = 1_000_000_007;
        ArrayList<Integer> bin = new ArrayList<Integer>();
        while(n>0){
            bin.add((int)(n%2));
            n=n/2;
        }
        ArrayList<Long> powers = new ArrayList<>();
        for(int i=0;i<bin.size();i++){
            if(bin.get(i)!=0){
                 powers.add((1L << i)%MOD);
            }
        }
        for (int i = 1; i < powers.size(); i++) {
            powers.set(i, (powers.get(i) %MOD* powers.get(i - 1)%MOD)%MOD);
        }
        int[] res=new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            long ans;
            if(a==0){
                ans=powers.get(b)%MOD;
               
            }else{
                long numerator = powers.get(b) % MOD;
                long denominator = powers.get(a - 1) % MOD;
                // multiply by modular inverse instead of dividing directly
                ans = (numerator * modPow(denominator, MOD - 2, MOD)) % MOD;
            }
            res[i] = (int) (ans % MOD);
        }
        // final long MOD = 1_000_000_007L;

        // ArrayList<Integer> bin = new ArrayList<>();
        // while (n > 0) {
        //     bin.add(n % 2);
        //     n = n / 2;
        // }

        // ArrayList<Long> powers = new ArrayList<>();
        // for (int i = 0; i < bin.size(); i++) {
        //     if (bin.get(i) != 0) {
        //         powers.add(1L << i);
        //     }
        // }
        // int[] res = new int[queries.length];
        // for (int i = 0; i < queries.length; i++) {
        //     int a = queries[i][0];
        //     int b = queries[i][1];
        //     long prod = 1;
        //     for (int j = a; j <= b; j++) {
        //         prod = (prod * (powers.get(j) % MOD)) % MOD; // prevent overflow
        //     }
        //     res[i] = (int) prod;

        // }
        return res;
    }
}
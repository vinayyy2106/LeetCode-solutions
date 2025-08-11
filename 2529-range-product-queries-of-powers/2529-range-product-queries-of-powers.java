import java.math.BigInteger;
class Solution {
    public int[] productQueries(int n, int[][] queries) {
        // final long MOD = 1_000_000_007;
        // ArrayList<Integer> bin = new ArrayList<Integer>();
        // while(n>0){
        //     bin.add((int)(n%2));
        //     n=n/2;
        // }
        // ArrayList<Long> powers = new ArrayList<>();
        // for(int i=0;i<bin.size();i++){
        //     if(bin.get(i)!=0){
        //          powers.add((1L << i)%MOD);
        //     }
        // }
        // for (int i = 1; i < powers.size(); i++) {
        //     powers.set(i, (powers.get(i) * powers.get(i - 1))%MOD);
        // }
        // int[] res=new int[queries.length];

        // for(int i=0;i<queries.length;i++){
        //     int a=queries[i][0];
        //     int b=queries[i][1];
        //     long ans;
        //     if(a==0){
        //         ans=powers.get(b);
               
        //     }else{
        //         ans=(powers.get(b)/powers.get(a-1));
        //     }
        //     res[i] = (int) (ans % MOD);
        // }
        final long MOD = 1_000_000_007L;

        ArrayList<Integer> bin = new ArrayList<>();
        while (n > 0) {
            bin.add(n % 2);
            n = n / 2;
        }

        ArrayList<Long> powers = new ArrayList<>();
        for (int i = 0; i < bin.size(); i++) {
            if (bin.get(i) != 0) {
                powers.add(1L << i);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            long prod = 1;
            for (int j = a; j <= b; j++) {
                prod = (prod * (powers.get(j) % MOD)) % MOD; // prevent overflow
            }
            res[i] = (int) prod;

        }
        return res;
    }
}
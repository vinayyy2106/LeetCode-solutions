import java.math.BigInteger;
class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final BigInteger MOD = BigInteger.valueOf(1_000_000_007L);
        ArrayList<Integer> bin = new ArrayList<Integer>();
        while(n>0){
            bin.add((int)(n%2));
            n=n/2;
        }
        ArrayList<BigInteger> powers = new ArrayList<>();
        for(int i=0;i<bin.size();i++){
            if(bin.get(i)!=0){
                 powers.add(BigInteger.valueOf(1L << i));
            }
        }
        for (int i = 1; i < powers.size(); i++) {
            powers.set(i, powers.get(i).multiply(powers.get(i - 1)));
        }
        int[] res=new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            BigInteger ans;
            if (a == 0) {
                ans = powers.get(b);
            } else {
                ans = powers.get(b).divide(powers.get(a - 1)); 
            }
            res[i] = ans.mod(MOD).intValue(); 
        }
        return res;
    }
}
class Solution {
    public int countTriples(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int val=(int)Math.sqrt(i*i +j*j +1);
                if(val<=n && (val*val==i*i+j*j))res++;
            }
        }
        return res;
    }
}
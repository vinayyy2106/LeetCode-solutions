class Solution {
    public int countTriples(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int square=i*i +j*j;
                int val=(int)Math.sqrt( square+1);
                if(val<=n && (val*val==square))res++;
            }
        }
        return res;
    }
}
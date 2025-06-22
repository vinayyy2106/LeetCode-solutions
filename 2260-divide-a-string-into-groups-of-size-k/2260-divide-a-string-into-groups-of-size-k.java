class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        int rem=n%k;
        if(rem!=0){
            int f=k-rem;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < f; i++) {
                sb.append(fill);
            }
            s = sb.toString();
            n = s.length();
        }
        String[] result = new String[n / k];
        for(int i=0;i<n;i+=k){
            result[i/k]=s.substring(i,i+k);
        }
        return result;
    }
}
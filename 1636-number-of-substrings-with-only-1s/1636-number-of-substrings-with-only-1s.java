class Solution {
    public int numSub(String s) {
        long count=0;
        long ones=0;
        int mod = 1000000007;
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                ones++;
            }
            else {
                count+=(((ones)*(ones+1))/2) % mod;
                ones=0;
            }
        }
        count+=(((ones)*(ones+1))/2) % mod;
        return (int)count%mod;
    }
}
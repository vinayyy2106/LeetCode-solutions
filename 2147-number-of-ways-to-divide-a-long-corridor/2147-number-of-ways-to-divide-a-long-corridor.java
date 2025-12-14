class Solution {
    public int numberOfWays(String corridor) {
        long MOD = 1_000_000_007;
        List<Integer> listOfSeats=new ArrayList<>();
        int n=corridor.length();
        for(int i=0;i<n;i++){
            if(corridor.charAt(i)=='S')listOfSeats.add(i);
        }
        int size=listOfSeats.size();
        if(size==0 || size%2!=0)return 0;
        long res=1;
        int end_prev_index=listOfSeats.get(1);
        for(int i=2;i<size;i+=2){
            int length=listOfSeats.get(i)-end_prev_index;
            res=(res*length)%MOD;
            end_prev_index=listOfSeats.get(i+1);
        }
        return (int)res;
    }
}
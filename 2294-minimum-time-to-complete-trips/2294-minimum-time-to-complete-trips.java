class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1;
        long r = (long) Arrays.stream(time).min().getAsInt() * totalTrips;

        while(l<r){
            long mid=l+(r-l)/2;
            if(ifPossible(time,totalTrips,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r;
    }
    public boolean ifPossible(int[] time,int totalTrips,long timeAvailable){
        long n=0;
        for(int a:time){
            n+=timeAvailable/a;
            if(n>=totalTrips)return true;
        }
        return false;
    }
}
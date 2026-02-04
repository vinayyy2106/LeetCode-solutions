class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int n=intervals.length;
        int count=1;
        int index=0;
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=intervals[index][1]){
                count++;
                index=i;
            }
        }
        return n-count;
    }
}
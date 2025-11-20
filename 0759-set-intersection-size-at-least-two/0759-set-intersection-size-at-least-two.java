class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,((a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]));
        int a=intervals[0][1]-1;
        int b=intervals[0][1];
        int count=2;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=a){
                continue;
            }else if(intervals[i][0]<=b){
                if (intervals[i][1] == b) {
                    // intervals[i][1] == b → adding R does nothing → need to add R-1
                    a = b - 1;
                } else {
                    // normal case
                    a = b;
                    b = intervals[i][1];
                }
                count++;
            }else{
                a=intervals[i][1]-1;
                b=intervals[i][1];
                count+=2;
            }
        }
        return count;
    }
}
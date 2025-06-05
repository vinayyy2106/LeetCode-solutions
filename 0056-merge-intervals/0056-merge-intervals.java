class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();
        int n=intervals.length;
        for(int i=0;i<n;i++){
            if(merged.isEmpty() || intervals[i][0]>merged.get(merged.size()-1)[1]){
                merged.add(intervals[i]);
            }
            else{
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],intervals[i][1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
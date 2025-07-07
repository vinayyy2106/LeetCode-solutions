class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]); 
                } else {
                    return Integer.compare(a[1], b[1]); 
                }
            }
        });
        int lastDay=0;
        int i=0;
        int attended=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int[] eve:events){
            lastDay=Math.max(lastDay,eve[1]);
        }
        for(int day=1;day<=lastDay;day++){
            while(i<events.length && events[i][0]==day){
                
                pq.offer(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                attended++;
            }
        }
        return attended;
    }
}
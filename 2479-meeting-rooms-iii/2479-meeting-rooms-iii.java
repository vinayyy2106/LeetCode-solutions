class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m=meetings.length;
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int[] result=new int[n];
        PriorityQueue<meetData> pq=new PriorityQueue<>((a,b)->(a.lastTime==b.lastTime?a.roomNo-b.roomNo:a.lastTime-b.lastTime));
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq1.offer(i);
        }
        for(int[] meet:meetings){
            if(pq.size()>0 && pq.peek().lastTime<=meet[0]){
                while(!pq.isEmpty() && pq.peek().lastTime<=meet[0]){
                    meetData md=pq.poll();
                    pq1.offer(md.roomNo);
                }
                if(pq1.size()>0){
                    int ind=pq1.poll();
                    pq.offer(new meetData(meet[1],ind));
                    result[ind]++;
                }
            }else if(pq1.size()!=0){
                int ind1=pq1.poll();
                pq.offer(new meetData(meet[1],ind1));
                result[ind1]++;
            }else{
                int val=meet[1]-meet[0];
                meetData used=pq.poll();
                pq.offer(new meetData(used.lastTime+val,used.roomNo));
                result[used.roomNo]++;
            }
        }
        int max = 0, res = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
                res = i;
            }
        }
        return res;
    }
}
class meetData{
    int lastTime;
    int roomNo;
    public meetData(int lastTime,int roomNo){
        this.lastTime=lastTime;
        this.roomNo=roomNo;
    }
}
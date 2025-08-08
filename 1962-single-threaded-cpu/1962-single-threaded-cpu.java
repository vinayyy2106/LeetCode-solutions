class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int[][] sortedTasks=new int[n][3];
        for(int i=0;i<n;i++){
            sortedTasks[i][0]=tasks[i][0];//start time
            sortedTasks[i][1]=tasks[i][1];//processing time
            sortedTasks[i][2]=i;
        }
        Arrays.sort(sortedTasks,(a,b)->(a[0]-b[0]));
        List<Integer> res=new ArrayList<>();
        int ind=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);//a[0],b[0] -processng time and a[1],b[1]- index;
        long current_time=0;
        while(ind<n || !pq.isEmpty()){
            if(pq.isEmpty() && current_time<sortedTasks[ind][0]){
                current_time=sortedTasks[ind][0];
            }
            while(ind<n && sortedTasks[ind][0]<=current_time){
                pq.offer(new int[]{sortedTasks[ind][1],sortedTasks[ind][2]});//storing processing time and index
                ind++;
            }
            int[] temp=pq.poll();
            current_time+=temp[0];
            res.add(temp[1]);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
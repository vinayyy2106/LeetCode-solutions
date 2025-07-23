class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr=new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char ch:tasks){
            arr[ch-'A']++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                pq.offer(arr[i]);
            }
        }
        int time=0;
        while(!pq.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    int frq=pq.poll();
                    frq--;
                    temp.add(frq);
                }
            }
            int a=temp.size();
            for(int i=0;i<a;i++){
                if(temp.get(i)>0)pq.offer(temp.get(i));
            }
            if(pq.isEmpty()){
                time+=temp.size();
            }else{
                time+=(n+1);
            }
        }
        return time;
    }
}
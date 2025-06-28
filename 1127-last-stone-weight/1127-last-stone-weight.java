class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        while(pq.size()>1){
            int f=pq.poll();
            int s=pq.poll();
            if(f-s!=0){
                pq.offer(f-s);
            }
        }
        return pq.isEmpty()?0:pq.peek();
    }
}
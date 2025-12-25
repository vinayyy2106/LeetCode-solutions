class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        for(int hp:happiness){
            pq.add(hp);
        }
        int i=0;
        long sum=0;
        while(i<k && !pq.isEmpty()){
            int val=pq.poll()-i;
            if(val>0)sum+=val;
            i++;
        }
        return sum;
    }
}
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] sum=new int[k];
        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
            if(pq.size()>k)pq.poll();
        }
       ArrayList<int[]> list=new ArrayList<>(pq);
       list.sort((a,b)->a[1]-b[1]);
       int[] num=new int[k];
       int i=0;
       for(int[] n:list){
        num[i]=n[0];
        i++;
       }
       return num;
    }
}
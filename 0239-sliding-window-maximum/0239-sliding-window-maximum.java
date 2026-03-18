class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        int j=0;
        res[j++]=nums[dq.peekFirst()];
        for(int i=k;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            res[j++]=nums[dq.peekFirst()];
        }
        return res;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(stack.size()>0 && nums[stack.peekLast()]<=nums[i]){
                stack.pollLast();
            }
            stack.offerLast(i);
        }
        int[] res=new int[n-k+1];
        int j=0;
        res[j++]=nums[stack.peekFirst()];
        for(int i=k;i<n;i++){
            
            //remove the elements not partof this window.
             while(!stack.isEmpty() && stack.peekFirst()<=i-k){
                stack.pollFirst();
            }
            while(!stack.isEmpty() && nums[stack.getLast()]<=nums[i]){
                stack.pollLast();
            }
            
            stack.offerLast(i);
            res[j++]=nums[stack.peekFirst()];
        }
        return res;
    }
}
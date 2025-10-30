class Solution {
    public int minNumberOperations(int[] target) {
        int prev=0;
        int curr=0;
        int res=0;
        for(int i=0;i<target.length;i++){
            curr=target[i];
            if(curr>prev)res+=Math.abs(curr-prev);
            prev=curr;
        }
        return res;
    }
}
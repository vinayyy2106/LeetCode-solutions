class Solution {
    private int total=0;
    public int countMaxOrSubsets(int[] nums) {
        total = 0;
        int n=nums.length;
        int xor=0;
        for(int i=0;i<n;i++){
            xor|=nums[i];
        }
        helper(0,n,xor,nums,0);
        return total;
    }
    public void helper(int i,int n,int xor,int[] nums,int val){
        if(i==n){
            if(val==xor) total++;
            return;
        }
        helper(i+1,n,xor,nums,val|nums[i]);
        helper(i+1,n,xor,nums,val);
    }
    // public boolean checkXOR(List<Integer> li,int xor){
    //     int s=0;
    //     for(int i=0;i<li.size();i++){
    //         s^=li.get(i);
    //     }
    //     return s==xor;
    // }
}
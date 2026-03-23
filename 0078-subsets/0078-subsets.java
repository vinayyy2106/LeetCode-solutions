class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li=new ArrayList<>();
        helper(nums,li,0,new ArrayList<>());
        return li;
    }
    public void helper(int[] nums,List<List<Integer>> li,int i,List<Integer> l){
        if(i==nums.length){
            li.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        helper(nums,li,i+1,l);
        l.remove(l.size()-1);
        helper(nums,li,i+1,l);
    }
}
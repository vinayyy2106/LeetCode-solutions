class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        recursion(nums,lists,0);
        return lists;
    }
    public void recursion(int[] nums,List<List<Integer>> lists,int ind){
        if(ind==nums.length){
            List<Integer> li=new ArrayList<>();
            for(int num:nums){
                li.add(num);
            }
            lists.add(li);
            return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(nums,i,ind);
            recursion(nums,lists,ind+1);
            swap(nums,i,ind);
        }
    }
    static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
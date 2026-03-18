class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        helper(list,nums,0);
        return list;
    }
    public void helper(List<List<Integer>> list,int[] nums,int ind){
        if(ind==nums.length){
            List<Integer> li=new ArrayList<>();
            for(int num:nums)li.add(num);
            list.add(li);
        }
        for(int i=ind;i<nums.length;i++){
            swap(nums,ind,i);
            helper(list,nums,ind+1);
            swap(nums,ind,i);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
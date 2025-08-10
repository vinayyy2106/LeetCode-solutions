class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        helper(nums,0,res,n);
        return res;
    }
    public void helper(int[] nums,int idx,List<List<Integer>> res,int n){
        if(idx==n){
            List<Integer> s=new ArrayList<>();
            for(int i=0;i<n;i++){
                s.add(nums[i]);
            }
            res.add(s);
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=idx;i<n;i++){
            if(set.contains(nums[i]))continue;
            set.add(nums[i]);
            swap(nums,i,idx);
            helper(nums,idx+1,res,n);
            swap(nums,i,idx);
        }
    }
    static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
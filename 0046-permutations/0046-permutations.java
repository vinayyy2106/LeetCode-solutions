class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList=new ArrayList<>();
        findFullList(0,finalList,nums,nums.length);
        return finalList;
    }
    static void findFullList(int index,List<List<Integer>> finalList,int[] nums,int n){
        // ArrayList<Integer> l1=new ArrayList<Integer>(list);
        if(index==n){
            List<Integer> s=new ArrayList<>();
            for(int i=0;i<n;i++){
                s.add(nums[i]);
            }
            finalList.add(s);
            return;
        }
        for(int i=index;i<n;i++){
            swap(nums,i,index);
            findFullList(index+1,finalList,nums,n);
            swap(nums,i,index);
        }
    }
    static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
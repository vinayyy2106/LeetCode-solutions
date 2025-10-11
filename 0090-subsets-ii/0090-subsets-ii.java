class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> li=new ArrayList<>();
        if(nums.length==1){
            li.add(new ArrayList<>());
            List<Integer> r=new ArrayList<>();
            r.add(nums[0]);
            li.add(r);
            return li;
        }else{
            recursion(li,new ArrayList<>(),0,nums);
        }
        return li;
    }
    public void recursion(List<List<Integer>> li,List<Integer> temp,int i,int[] nums){
        if(i==nums.length){
            li.add(new ArrayList(temp));
            return;
        }
        temp.add(nums[i]);
        recursion(li,temp,i+1,nums);
        temp.remove(temp.size()-1);
        int newIndex=i+1;
        while(newIndex<nums.length && nums[newIndex]==nums[i])newIndex+=1;
        recursion(li,temp,newIndex,nums);
    }
}
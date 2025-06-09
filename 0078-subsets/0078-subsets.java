class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arrList=new ArrayList<>();
        if(nums.length==1){
            arrList.add(new ArrayList<>());
            List<Integer> li=new ArrayList<>();
            li.add(nums[0]);
            arrList.add(li);
            return arrList;
        }else{
            returnSubsetArray(arrList,0,nums,new ArrayList<Integer>());
            return arrList;
        }
        
    }
    static void returnSubsetArray(List<List<Integer>> arrList,int index,int[] nums,ArrayList<Integer> list){
       
        if(index==nums.length){
            arrList.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        returnSubsetArray(arrList,index+1,nums,list);
        if(list.size()>0){
            list.remove(list.size()-1);
        }
        returnSubsetArray(arrList,index+1,nums,list);
    }
}
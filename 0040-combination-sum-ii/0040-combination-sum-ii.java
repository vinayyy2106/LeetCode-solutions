class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> li=new ArrayList<>();
        recursion(li,new ArrayList<>(),target,0,candidates);
        return li;
    }
    public void recursion(List<List<Integer>> li,List<Integer> temp,int target,int i,int[] candidates){
        if(i==candidates.length){
            if(target==0){
                li.add(new ArrayList(temp));
            }
            return;
        }
        
        if(candidates[i]<=target){
            temp.add(candidates[i]);
            recursion(li,temp,target-candidates[i],i+1,candidates);
            temp.remove(temp.size()-1);
        }
        int numIndex=i+1;
        while(numIndex<candidates.length && candidates[numIndex]==candidates[i])numIndex++;
        recursion(li,temp,target,numIndex,candidates);
    }
}
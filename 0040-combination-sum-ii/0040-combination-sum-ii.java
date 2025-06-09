class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> ans=new ArrayList<>();
         Arrays.sort(candidates);
        returnSol(0,candidates,target,ans,new ArrayList<Integer>());
        return ans;
    }
    static void returnSol(int index,int[] c,int target,List<List<Integer>> ans,ArrayList<Integer> listToBeAdded){
            if(index==c.length){
            if(target==0){
                ans.add(new ArrayList<>(listToBeAdded));
            }
            return;
        }
        if(c[index]<=target){
            listToBeAdded.add(c[index]);
            returnSol(index+1,c,target-c[index],ans,listToBeAdded);
            listToBeAdded.remove(listToBeAdded.size()-1);
        }
        int newindex=index+1;
        while(newindex<c.length && c[newindex]==c[index])newindex++;
        returnSol(newindex,c,target,ans,listToBeAdded);
    }
}
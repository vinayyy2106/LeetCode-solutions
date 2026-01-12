class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        returnSol(0,candidates,target,ans,new ArrayList<Integer>());
        return ans;
    }
    static void returnSol(int index, int[] c, int target,
                      List<List<Integer>> ans,
                      ArrayList<Integer> list) {

    if (target == 0) {
        ans.add(new ArrayList<>(list));
        return;
    }

    if (index == c.length || target < 0) {
        return;
    }

    list.add(c[index]);
    returnSol(index, c, target - c[index], ans, list);
    list.remove(list.size() - 1);

    returnSol(index + 1, c, target, ans, list);
}

}
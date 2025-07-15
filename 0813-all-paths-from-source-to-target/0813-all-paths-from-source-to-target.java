class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        helper(graph,tempList,list,0,graph.length-1);
        return list;
    }
    public void helper(int[][] graph,List<Integer> list,List<List<Integer>> li,int org,int target){
        list.add(org);
        if(org==target){
            li.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        for(int node:graph[org]){
            helper(graph,list,li,node,target);
        }
        list.remove(list.size()-1);
    }
}
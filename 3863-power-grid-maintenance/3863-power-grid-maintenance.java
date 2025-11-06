class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> adj=new ArrayList<>();
        // SortedSet<String> set = new TreeSet<>();
        boolean[] vis=new boolean[c+1];
        for (int i = 0; i <= c; i++) adj.add(new ArrayList<>());
        for(int[] arr:connections){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        int[] indexHelp=new int[c+1];
        Map<Integer,SortedSet<Integer>> mp=new HashMap<>();
        for(int i=1;i<=c;i++){
            if(!vis[i]){
                int component_index=i;
                dfs(i,adj,vis,component_index,indexHelp,mp);
            }   
        }
        List<Integer> res=new ArrayList<>();
        
        for(int[] arr:queries){
            int type=arr[0]; // 1 || 2
            int node=arr[1];
            int id=indexHelp[node];
            SortedSet<Integer> set = mp.getOrDefault(id, new TreeSet<>());

            if(type==1){
                
                if(set.contains(node)){
                    res.add(node);
                }else if(!set.isEmpty()){
                    res.add(set.first());
                }else{
                    res.add(-1);
                }
            }else{
               set.remove(node);
            }
            
        }
        int[] result=new int[res.size()];
        for(int i=0;i<result.length;i++){
            result[i]=res.get(i);
        }
        return result;
    }
    public void dfs(int node,List<List<Integer>> adj,boolean[] vis,int compIndex,int[] indexHelp,Map<Integer,SortedSet<Integer>> mp){
        vis[node]=true;
        mp.putIfAbsent(compIndex, new TreeSet<>());
        mp.get(compIndex).add(node);
        indexHelp[node]=compIndex;
        for(int val:adj.get(node)){
            if(!vis[val]){
                dfs(val,adj,vis,compIndex,indexHelp,mp);
            }
        }
    }
}
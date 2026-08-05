class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        boolean[] suspicious=new boolean[n];
        for(int[] edge:invocations){
            li.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        q.offer(k);
        suspicious[k]=true;
        while(!q.isEmpty()){
            int val=q.poll();
            for(int edge:li.get(val)){
                indegree[edge]--;
                if(suspicious[edge]==false)q.add(edge);
                suspicious[edge]=true;
            }
        }
        List<Integer> result = new ArrayList<>();
        boolean cannotRemove = false;
        for(int i = 0; i  < n; i++) {
            if(suspicious[i] && indegree[i] > 0) {
                cannotRemove = true;
                break;
            }
            if(!suspicious[i]) {
                result.add(i);
            }
        }
        if(cannotRemove) {
            List<Integer> vec = new ArrayList<>(); 
            for(int i = 0; i < n; i++) {
                vec.add(i);
            }
            return vec;
        }
        return result;
    }
}
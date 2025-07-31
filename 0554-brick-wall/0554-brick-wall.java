class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> mp=new HashMap<>();
        int max=0;
        for(List<Integer> li:wall){
            int idx=0;
            for(int i=0;i<li.size()-1;i++){
                idx+=li.get(i);
                mp.put(idx, mp.getOrDefault(idx, 0) + 1);
                max=Math.max(max,mp.get(idx));
            }
        }
        return wall.size()-max;
    }
}
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!mp.containsKey(i-j)){
                    List<Integer> li=new ArrayList<>();
                    li.add(grid[i][j]);
                    mp.put(i-j,li);
                }else{
                   mp.get(i-j).add(grid[i][j]);
                }
            }
        }
        for (Integer key : mp.keySet()) {
            if(key<0){
                Collections.sort(mp.get(key),(a,b)->(b-a));
            }else{
                Collections.sort(mp.get(key));
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Integer> li=mp.get(i-j);
                grid[i][j]=li.remove(li.size()-1);
            }
        }
        return grid;
    }
}
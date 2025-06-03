class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            int ans=1;
            for(int col=1;col<row;col++){
                ans=ans*(row-col);
                ans=ans/col;
                temp.add(ans);
            }
            list.add(temp);
        }
        return list;
    }
    
}
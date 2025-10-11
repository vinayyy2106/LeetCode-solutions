class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists=new ArrayList<>();
        List<String> board=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        helper(0,lists,board);
        return lists;
    }
    public void helper(int row,List<List<String>> lists,List<String> board){
        if(row==board.size()){
            lists.add(new ArrayList(board));
            return;
        }
        for(int i=0;i<board.get(row).length();i++){
            if(isPossible(row,i,board)){
                char[] rowArr = board.get(row).toCharArray();
                rowArr[i]='Q';
                board.set(row, new String(rowArr));
                helper(row+1,lists,board);
                rowArr[i] = '.';
                board.set(row, new String(rowArr));
            }
        }
    }
    public boolean isPossible(int i,int j,List<String> board){
        int r=i-1,c=j-1;
        while(r>=0 && c>=0){
            if(board.get(r).charAt(c)=='Q')return false;
            r--;
            c--;
        }
        r=i-1;
        c=j;
        while(r>=0){
            if(board.get(r).charAt(c)=='Q')return false;
            r--;
        }
        r=i-1;
        c=j+1;
        while(r>=0 && c < board.size()){
            if(board.get(r).charAt(c)=='Q')return false;
            r--;
            c++;
        }
        return true;
    }
}
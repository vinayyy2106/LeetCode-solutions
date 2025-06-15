class Solution {
    public List<List<String>> solveNQueens(int n) {
        if(n==1){
            List<String> row=new ArrayList<>();
            row.add("Q");
            List<List<String>> result =new ArrayList<>();
            result.add(row);
            return result;
        }else{
            List<List<String>> result =new ArrayList<>();
            char[][] board=new char[n][n];
            for(int row=0;row<n;row++){
                for(int col=0;col<n;col++){
                    board[row][col]='.';
                }
            }
            queenPlacing(n,board,0,result);//0 is row number
            return result;
        }
    }
    static void queenPlacing(int size,char[][] board,int row,List<List<String>> result){
        if(row==size){
            // List<List<String>> listOfLists = new ArrayList<>();
            result.add(constructBoard(board));
            return;
        }
        for(int col=0;col<size;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                queenPlacing(size,board,row+1,result);
                board[row][col]='.';
            }
        }
    }
    static Boolean isSafe(char[][] list,int r,int c){
        for(int k=0;k<r;k++){
            if(list[k][c]=='Q'){
                return false;//checking vertically down
            }
        }
        int maxLeft=Math.min(r,c);
        for(int l=1;l<=maxLeft;l++){
            if(list[r-l][c-l]=='Q'){
                return false;//left diagonal
            }
        }
        int maxRight=Math.min(r,list.length-c-1);
        for(int m=1;m<=maxRight;m++){
            if(list[r-m][c+m]=='Q'){
                return false;//left diagonal
            }
        }
        return true;
    }
    static List<String> constructBoard(char[][] b){
        List<String> paths=new ArrayList<>();
        for(char[] a:b){
            paths.add(new String(a));
        }
        return paths;
    }
}
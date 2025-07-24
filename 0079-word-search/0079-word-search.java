class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] helperArr=new boolean[board.length][board[0].length];
                    if (helper(board, helperArr, word, i, j,word.length(), 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board,boolean[][] arr,String word,int i,int j,int len,int index){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(index) || arr[i][j]){
            return false;
        }
        if(index==len-1){
            return true;
        }
        boolean found;
        arr[i][j]=true;
        found=helper(board,arr,word,i-1,j,len,index+1) || helper(board,arr,word,i+1,j,len,index+1) || helper(board,arr,word,i,j+1,len,index+1) || helper(board,arr,word,i,j-1,len,index+1);
        arr[i][j]=false;
        return found;
    }
}
class Solution {
    int n;
    int[][] tScore;
    int[][] tPaths;
     int[][] dir = {
        {-1, 0},   
        {0, -1},   
        {-1, -1}  
    };
    int MOD = 1_000_000_007;
     private boolean isValid(int i, int j, List<String> board) {
        return i >= 0 && i < n && j >= 0 && j < n &&
               board.get(i).charAt(j) != 'X';
    }
    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();
        tScore = new int[n][n];
        tPaths = new int[n][n];
        for (int[] row : tScore)
            Arrays.fill(row, -1);
        int[] ans = solve(n - 1, n - 1, board);

        return new int[]{ans[0], ans[1]};
    }
    public int[] solve(int r,int c,List<String> board){
        char ch=board.get(r).charAt(c);
        if(ch=='E'){
            return new int[]{0,1};
        }
        if(ch=='X'){
            return new int[]{0,0};//score,path
        }
        if (tScore[r][c] != -1) return new int[]{tScore[r][c], tPaths[r][c]};

        int bestScore = -1;
        int bestPaths = 0;
        for(int[] d:dir){
            int row=r+d[0];
            int col=c+d[1];
            if(!isValid(row,col,board)){
                continue;
            }
            int[] next=solve(row,col,board);
            if(next[1]==0)continue;
            int score=next[0]+getValue(ch);
            if(score>bestScore){
                bestScore=score;
                bestPaths=next[1];
            }else if (score == bestScore) {
                bestPaths = (bestPaths + next[1]) % MOD;
            }
            
        }
        if (bestScore == -1) {
                bestScore = 0;
                bestPaths = 0;
        }
        tScore[r][c] = bestScore;
        tPaths[r][c] = bestPaths;
        return new int[]{bestScore, bestPaths};
    }
    public int getValue(char ch){
        if(ch=='S' || ch=='E')return 0;
        return ch-'0';
    }
}
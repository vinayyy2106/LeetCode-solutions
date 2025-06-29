class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int n_1=instructions.length;
        int n_2=values.length;
        long score=0;
        boolean[] visited = new boolean[n_1];
        int i=0;
        while(i<n_1){
            if(visited[i])break;
            visited[i]=true;
            if(instructions[i].equals("add") ){
                score+=values[i];
                
                i++;

            }else if(instructions[i].equals("jump") ){
                if(i+values[i]<n_1 && i+values[i]>=0)i+=values[i];
                else break;
                
            }
        }
        return score;
    }
}
class Solution {
    
    public int maximumGain(String s, int x, int y) { 
        if (x > y) {
            Result r1 = removePattern(s, 'a', 'b', x); 
            Result r2 = removePattern(r1.str, 'b', 'a', y);
            return r1.score+r2.score;
        } else {
            Result r1 = removePattern(s, 'b', 'a', y); 
            Result r2 = removePattern(r1.str, 'a', 'b', x);
            return r1.score+r2.score;
        }
    }
    public Result removePattern(String s,char a,char b,int val){
        StringBuilder str=new StringBuilder();
        int total=0;
        for(char ch:s.toCharArray()){
            int len=str.length();
            if(len>0 && str.charAt(len-1)==a && ch==b){
                total+=val;
                str.deleteCharAt(len-1);
            }else{
                str.append(ch);
            }
        }
        Result res=new Result(str.toString(),total);
        return res;
    }
}
 class Result {
        String str;
        int score;

        Result(String str, int score) {
            this.str = str;
            this.score = score;
        }
    }
class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int ans=0;
        int open=0;
        int close=0;
        //left to right
        
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                open++;
            }else{
                close++;
            }
            if(open>close)continue;
            if(close>open){
                open=0;
                close=0;
                continue;
            }
            ans=Math.max(open+close,ans);
        }

        open=0;
        close=0;
        //right to left

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='('){
                open++;
            }else{
                close++;
            }
            if(close>open)continue;
            if(open>close){
                open=0;
                close=0;
                continue;
            }
            ans=Math.max(open+close,ans);
        }

        return ans;
    }
}
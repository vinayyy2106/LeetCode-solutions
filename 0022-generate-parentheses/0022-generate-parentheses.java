class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(0,0,n,res,"");
        return res;
    }
    public void helper(int o,int c,int n,List<String> res,String str){
       
            if(o==c && o+c==2*n)res.add(str);
        
        if(o<n){
            helper(o+1,c,n,res,str+"(");
        }
        if(c<o){
            helper(o,c+1,n,res,str+")");
        }
    }
}
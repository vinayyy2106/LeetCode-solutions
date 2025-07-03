class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        StringBuilder str=new StringBuilder("");
        helper(list,str,0,0,n);
        return list;
    }
    public void helper(List<String> list,StringBuilder str,int oc,int cc,int n){
        if(oc==n && cc==n){
            list.add(str.toString());
            return;
        }
        if(oc<n){
            helper(list,str.append('('),oc+1,cc,n);
            str.deleteCharAt(str.length()-1);
        }
        if(cc<oc){
             helper(list,str.append(')'),oc,cc+1,n);
             str.deleteCharAt(str.length()-1);
        }
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        String str="";
        helper(list,str,0,0,n);
        return list;
    }
    public void helper(List<String> list,String str,int oc,int cc,int n){
        if(oc==n && cc==n){
            list.add(str);
            return;
        }
        if(oc<n){
            helper(list,str+'(',oc+1,cc,n);
        }
        if(cc<oc){
             helper(list,str+')',oc,cc+1,n);
        }
    }
}
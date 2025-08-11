class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression);
    }
    public List<Integer> helper(String s){
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='-' || s.charAt(i)=='+' || s.charAt(i)=='*' ){
                char ch=s.charAt(i);
                List<Integer> leftStringResults=helper(s.substring(0,i));
                List<Integer> rightStringResult=helper(s.substring(i+1));
                for(int val1:leftStringResults){
                    for(int val2:rightStringResult){
                        if(ch=='-')result.add(val1-val2);
                        else if(ch=='*')result.add(val1*val2);
                        else result.add(val1+val2);
                    }
                }
            }
        }
        if(result.size()==0)result.add(Integer.parseInt(s));
        return result;
    }
}
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> listOfLists=new ArrayList<>();
        List<String> list=new ArrayList<>();
        partitionsList(0,s,listOfLists,list);
        return listOfLists;
    }
    public void partitionsList(int ind,String s,List<List<String>> li,List<String> l){
        if(ind==s.length()){
            li.add(new ArrayList(l));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(ind,i,s)){
                l.add(s.substring(ind,i+1));
                partitionsList(i+1,s,li,l);
                l.remove(l.size()-1);
            }
        }
    }
    public boolean isPalindrome(int start,int end,String s){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}
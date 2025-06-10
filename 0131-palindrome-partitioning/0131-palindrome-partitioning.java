class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> listOfLists=new ArrayList<>();
        List<String> list=new ArrayList<>();
         partitionsList(0,s,listOfLists,list);
         return listOfLists;
    }
    public void partitionsList(int ind,String s,List<List<String>> lists,List<String> list){
        if(ind==s.length()){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                list.add(s.substring(ind,i+1));
                partitionsList(i+1,s,lists,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}
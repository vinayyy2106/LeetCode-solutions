class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n=arr.length;
        HashSet<Integer> prev=new HashSet<>();
        HashSet<Integer> curr=new HashSet<>();
        HashSet<Integer> result=new HashSet<>();
        for(int i=0;i<n;i++){
            curr.add(arr[i]);
            for(int x:prev){
                curr.add(arr[i]|x);
                result.add(arr[i]|x);
            }
            
            result.addAll(curr);
            prev=new HashSet<>(curr);
            curr.clear();
        }
        return result.size();
    }
    
}
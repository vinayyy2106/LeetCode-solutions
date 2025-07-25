class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        int[] maxArr=new int[26];
        for(int i=0;i<n;i++){
            int id=s.charAt(i)-'a';
            maxArr[id]=i;//storing last index
        }
        int i=0;
        List<Integer> res=new ArrayList<>();
        while(i<n){
            int end=maxArr[s.charAt(i) - 'a'];
            int j=i;
            while(j<end){
                end=Math.max(end,maxArr[s.charAt(j) - 'a']);
                j++;
            }
            res.add(j-i+1);
            i=j+1;
        }
        return res;
    }
}
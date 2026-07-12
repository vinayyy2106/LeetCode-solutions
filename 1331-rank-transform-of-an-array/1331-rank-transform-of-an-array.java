class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int rank=1;
        int n= arr.length;
        int[] temp=Arrays.copyOf(arr,n);
        Arrays.sort(temp);
        int[] ans=new int[n];
        if(n==0)return ans;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(temp[i])){
                continue;
            }else{
                mp.put(temp[i],rank++);
            }
        }
        for(int i=0;i<n;i++){
            ans[i]=mp.get(arr[i]);
        }
        return ans;
    }
}
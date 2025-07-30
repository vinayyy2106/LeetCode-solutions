class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum=0;
        int count=0;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<banned.length;i++){
            mp.put(banned[i],i);
        }
        for(int i=1;i<=n;i++){
            if(!mp.containsKey(i) && sum+i<=maxSum){
                sum+=i;
                count++;
            }
        }
        return count;
    }
}
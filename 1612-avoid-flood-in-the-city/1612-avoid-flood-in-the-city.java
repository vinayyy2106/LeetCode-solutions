class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        int[] ans=new int[n];
        TreeSet<Integer> set=new TreeSet<>();
        Map<Integer,Integer> mp=new HashMap<>();
        Arrays.fill(ans,1);
        for(int i=0;i<n;i++){
            int rain=rains[i];
            if(rain==0){
                set.add(i);
            }else{
                ans[i]=-1;
                if(mp.containsKey(rain)){
                    Integer nextZero=set.higher(mp.get(rain));
                    if(nextZero==null)return new int[0];
                    ans[nextZero]=rain;
                    set.remove(nextZero);
                }
                mp.put(rain,i);
            }
        }
        return ans;
    }
}
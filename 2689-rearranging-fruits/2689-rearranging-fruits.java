class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> map1=new HashMap<>();
        int ele=Integer.MAX_VALUE;
        for(int num:basket1){
            map1.put(num, map1.getOrDefault(num, 0) + 1);
            ele=Math.min(ele,num);
        }
        for(int num:basket2){
            map1.put(num, map1.getOrDefault(num, 0) - 1);
            ele=Math.min(ele,num);
        }
        List<Integer> extras = new ArrayList<>();
        for(int n:map1.keySet()){
            int count=map1.get(n);
            if(count % 2!=0){
                return -1;
            }
            count=Math.abs(count);
            for(int i=0;i<count/2;i++){
                extras.add(n);
            }
        }
        Collections.sort(extras);
        long totalCost=0;
        for(int i=0;i<extras.size()/2;i++){
            totalCost+=Math.min(extras.get(i),ele*2);
        }
        return totalCost;
    }
}
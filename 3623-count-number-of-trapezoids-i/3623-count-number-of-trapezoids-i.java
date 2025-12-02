class Solution {
    static final int M = (int)1e9 + 7;
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int[] arr:points){
            if(mp.containsKey(arr[1])){
                mp.put(arr[1],mp.getOrDefault(arr[1],0)+1);
            }else{
                mp.put(arr[1],1);
            }
        }
        long res=0;
        long prevHorLines=0;
        for (int count:mp.values()){
            long horizontalLines = (long) count * (count - 1) / 2; 
            res=(res+horizontalLines*prevHorLines)%M;
            prevHorLines+=horizontalLines;
        }
        return (int)(res%M);
    }
}
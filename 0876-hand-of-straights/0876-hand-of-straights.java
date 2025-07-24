class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        for (int key : count.keySet()) {
            int frq=count.get(key);
            if(frq>0){
                for(int i=0;i<groupSize;i++){
                    int newKey=key+i;
                    int currfreq=count.getOrDefault(newKey, 0);
                    if( currfreq >= frq){
                        count.put(newKey,count.get(newKey)-frq);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
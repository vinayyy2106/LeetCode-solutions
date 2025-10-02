class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int maxBottles=0;
        int emptyBottles=0;
        while(numBottles>0){
            maxBottles+=numBottles;
            emptyBottles+=numBottles;
            numBottles=0;
            if(emptyBottles<numExchange){
                break;
            }else{
                emptyBottles-=numExchange;
                numExchange++;
                numBottles++;
            }
        }
        return maxBottles;
    }
}
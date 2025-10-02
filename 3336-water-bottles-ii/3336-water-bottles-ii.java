class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int maxBottles=numBottles;
        int emptyBottles=numBottles;
        numBottles=0;
        while(emptyBottles>=numExchange){
            emptyBottles-=numExchange;
            numExchange++;
            numBottles++;
            maxBottles+=numBottles;
            emptyBottles+=numBottles;
            numBottles=0;
        }
        return maxBottles;
    }
}
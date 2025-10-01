class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        if(numBottles==numExchange)return numBottles+1;
        if(numBottles<numExchange)return numBottles;
        int maxBottles=numBottles;
        while(numBottles>=numExchange){
            int botCanBeExchanged=numBottles/numExchange;
            numBottles=botCanBeExchanged+(numBottles%numExchange);
            maxBottles+=botCanBeExchanged;
        }
        return maxBottles;
        
    }
}
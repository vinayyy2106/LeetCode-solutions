class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totCost=0;
        int totGas=0;
        for(int g:gas){
            totGas+=g;
        }
        for(int c:cost){
            totCost+=c;
        }
        if(totGas<totCost){
            return -1;
        }
        int tcost=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            tcost+=(gas[i]-cost[i]);
            if(tcost<0){
                start=i+1;
                tcost=0;
            }
        }
        return start;
    }
}
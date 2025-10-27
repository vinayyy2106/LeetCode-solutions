class Solution {
    public int numberOfBeams(String[] bank) {
        int count=0;
        int prevCount=0;
        for(int i=0;i<bank.length;i++){
            int currCount=0;
            for(char ch:bank[i].toCharArray()){
                if(ch=='1'){
                    currCount++;
                }
            }
            if(currCount>0){
                count+=(prevCount*currCount);
                prevCount=currCount;
            }
        }
        return count;
    }
}
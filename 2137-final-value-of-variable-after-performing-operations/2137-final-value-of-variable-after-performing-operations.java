class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val=0;
        for(String str:operations){
            if(str.equals("--X") || str.equals("X--")){
                val-=1;
            }else{
                val+=1;
            }
        }
        return val;
    }
}
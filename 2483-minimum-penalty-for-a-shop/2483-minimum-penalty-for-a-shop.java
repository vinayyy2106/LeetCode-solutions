class Solution {
    public int bestClosingTime(String customers) {
        int yCount=0;
        for(char ch:customers.toCharArray()){
            if(ch=='Y')yCount++;
        }
        int nCount=0;
        int n=customers.length();
        int max=Integer.MAX_VALUE;
        int bestHour=0;
        for(int i=0;i<=n;i++){
            int penalty=nCount+yCount;
            if(penalty<max){
                max=penalty;
                bestHour=i;
            }
            if(i<n){
                if(customers.charAt(i)=='Y'){
                    yCount--;
                }else{
                    nCount++;
                }
            }
        }
        return bestHour;
    }
}
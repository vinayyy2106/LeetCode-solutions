class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] charArr=colors.toCharArray();
        int n=charArr.length;
        int prev=0;
        int curr=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(i>0 && charArr[i]!=charArr[i-1]){
                prev=0;
            }
            curr=neededTime[i];
            res+=Math.min(prev,curr);
            prev=Math.max(prev,curr);
        }
        return res;
    }
}
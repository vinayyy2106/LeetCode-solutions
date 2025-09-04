class Solution {
    public int findClosest(int x, int y, int z) {
        int a=Math.abs(z-y);
        int b=Math.abs(z-x);
        if(a<b){
            return 2;
        }else if(a>b){
            return 1;
        }else{
            return 0;
        }
    }
}
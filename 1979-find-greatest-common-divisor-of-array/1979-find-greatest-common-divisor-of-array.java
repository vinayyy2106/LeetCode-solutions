class Solution {
    public int findGCD(int[] nums) {
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            if(num>max){
                max=num;
            }
            if(num<min){
                min=num;
            }
        }
        return gcd(max,min);
    }
    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
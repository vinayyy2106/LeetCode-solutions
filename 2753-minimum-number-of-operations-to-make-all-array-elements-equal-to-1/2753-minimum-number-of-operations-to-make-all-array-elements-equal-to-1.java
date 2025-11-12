class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int num:nums){
            if(num==1)count++;
        }
        if(count>0)return n-count;
        int res=Integer.MAX_VALUE;
        count=0;
        for(int i=0;i<n-1;i++){
            int currGcd=nums[i];
            for(int j=i+1;j<n;j++){
                currGcd=gcd(currGcd,nums[j]);
                if (currGcd == 1) {
                    res = Math.min(res, j - i); // (L - 1)
                    break;
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res+(n-1);
    }
    public int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

}
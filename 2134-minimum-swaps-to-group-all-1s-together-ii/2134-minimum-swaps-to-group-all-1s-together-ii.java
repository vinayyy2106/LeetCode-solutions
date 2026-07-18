class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[] newArr=new int[n*2];
        for(int i=0;i<2*n;i++){
            newArr[i]=nums[i%n];
        }
        int ones=0;
        for(int num:nums){
            if(num==1)ones++;
        }
        int i=0;
        int ans=0;
        int onesCount=0;
        for(int j=0;j<2*n;j++){
            if(newArr[j]==1){
                onesCount++;
            }
            while(j-i+1 > ones){
                if(newArr[i]==1){
                    onesCount--;
                    
                }
                i++;
            }
            ans=Math.max(onesCount,ans);
        }
        return ones-ans;
    }
}
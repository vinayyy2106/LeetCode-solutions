class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int[] bitWiseArray=new int[32];
        Arrays.fill(bitWiseArray,-1);
        for(int i=n-1;i>=0;i--){
            int endIndex=i;
            for(int j=0;j<32;j++){
                int val=1<<j;
                if((nums[i] & val)==0){
                    endIndex=Math.max(endIndex,bitWiseArray[j]);
                }else{
                    bitWiseArray[j]=i;
                }
            }
            res[i]=endIndex-i+1;
        }
        return res;   
    } 
}
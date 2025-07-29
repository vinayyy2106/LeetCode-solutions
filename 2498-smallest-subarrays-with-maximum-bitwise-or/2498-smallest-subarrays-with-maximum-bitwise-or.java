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
    public void helper(int i,int n,int xor,int[] nums,int val,List<Integer> list,int ele){
        if(i==n){
            if(val==xor)list.add(ele);
            return;
        }
        helper(i+1,n,xor,nums,val|nums[i],list,ele+1);
        helper(i+1,n,xor,nums,val,list,ele);
    }
}
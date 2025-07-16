class Solution {
    // public int length=Integer.MIN_VALUE;
    public int maximumLength(int[] nums) {
        // List<Integer> list=new ArrayList<>();
        // helper(0,nums,list);
        // return length;
        int n=nums.length;
        int odd=0;
        int even=0;
        
        for(int num:nums){
            if(num%2==0){
                even++;
            }else{
                odd++;
            }
        }
        int parity=nums[0]%2;
        int alternate=1;
        for(int i=1;i<n;i++){
            if(nums[i]%2!=parity){
                alternate++;
                parity=nums[i]%2;
            }
        }
        return Math.max(odd,Math.max(even,alternate));
    }
    // public void helper(int i,int[] nums,List<Integer> list){
    //     // if(i==nums.length){
    //     //     if(isValid(list)){
    //     //         length=Math.max(length,list.size());
                
    //     //     }
    //     //     return;
    //     // }
    //     // list.add(nums[i]);
    //     // helper(i+1,nums,list);
    //     // list.remove(list.size()-1);
    //     // helper(i+1,nums,list);
    // }
    // public boolean isValid(List<Integer> list){
        // if(list.size()<=2)return true;
        // int val=(list.get(0)+list.get(1))%2;
        // for(int i=1;i<list.size()-1;i++){
        //     if((list.get(i)+list.get(i+1))%2!=val)return false;
        // }
        // return true;
    // }
}
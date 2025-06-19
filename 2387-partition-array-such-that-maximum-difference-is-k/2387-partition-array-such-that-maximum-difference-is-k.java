class Solution {
    public int partitionArray(int[] nums, int k) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(num,max);
        }
        int[] countArray=new int[max+1];
        for(int num:nums){
            countArray[num]++;
        }
        int val=0;
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<=max;i++){
            
            while(countArray[i]>0){
                
                li.add(i);
                if(Math.abs(li.get(0)-li.get(li.size()-1))<=k){
                    countArray[i]--;
                    continue;
                }else{
                    val++;
                    li.remove(li.size()-1);
                    li=new ArrayList<>();
                }
                
            }
        }
        if(li.size()>0)val++;
        return val;
    }
}
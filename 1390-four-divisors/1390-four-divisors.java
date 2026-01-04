class Solution {
    public int sumFourDivisors(int[] nums) {
        Map<Integer,Integer> remember=new HashMap<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(remember.containsKey(nums[i])){
                sum+=remember.get(nums[i]);
                continue;
            }
            int dSum=0;
            int count=0;
            for(int j=1;j*j<=nums[i];j++){
                if(nums[i]%j==0){
                    if(nums[i]==j*j){
                        count++;
                        dSum+=j;
                    }else{
                        count+=2;
                        dSum+=j + nums[i]/j;
                    }
                    
                }
                if(count>4)break;
            }
            if(count==4){
                remember.put(nums[i],dSum);
                sum+=dSum;
            }
        }
        return sum;
    }
}
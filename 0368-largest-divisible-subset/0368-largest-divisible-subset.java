class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> dp=new ArrayList<>(Collections.nCopies(nums.length, 1));
        List<Integer> hash=new ArrayList<>(Collections.nCopies(nums.length, 0));
        int max=-1;
        int lastIndex=-1;
        for(int i=0;i<nums.length;i++){
            hash.set(i,i);
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && 1+dp.get(prev)>dp.get(i)){
                    dp.set(i,1+dp.get(prev));
                    hash.set(i,prev);
                }
            }
            if(dp.get(i)>max){
                max=dp.get(i);
                lastIndex=i;
            }
        }
        List<Integer> tp=new ArrayList<>();
        tp.add(nums[lastIndex]);
        while(hash.get(lastIndex)!=lastIndex){
            lastIndex=hash.get(lastIndex);
            tp.add(nums[lastIndex]);
        }
        Collections.reverse(tp);
        return tp;
    }
}
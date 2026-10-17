class Solution {
    public int minSwaps(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        Integer[] nums1=new Integer[n];
        for(int i=0;i<n;i++){
            mp.put(nums[i],i);
            nums1[i]=nums[i];
        }
        Arrays.sort(nums1,(a, b) -> {
            int sum1 = (int)getDigitSum(a);
            int sum2 = (int)getDigitSum(b);

            if (sum1 != sum2) {
                return Integer.compare(sum1, sum2);
            }

            return Integer.compare(a, b);
        });
        int swaps=0;
        for(int i=0;i<n;i++){
            if(nums[i]==nums1[i])continue;
            else{
                int ind=mp.get(nums1[i]);
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                swaps++;
                mp.put(nums[i],i);
                mp.put(nums[ind],ind);
            }
        }
        return swaps;
    }
    public long getDigitSum(int num){
        long sum=0;
        while(num>0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
}
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(0,nums.length-1,nums);
    }
    public int mergeSort(int low,int high,int[] nums){
        int cnt=0;
        if(low>=high){
            return cnt;
        }
        int mid=(low+high)/2;
        cnt+=mergeSort(low,mid,nums);
        cnt+=mergeSort(mid+1,high,nums);
        cnt+=noofpairs(low,mid,high,nums);
        merge(low,mid,high,nums);
        return cnt;
    }
    public int noofpairs(int low,int mid,int high,int[] nums){
        int right=mid+1;
        int cnt=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)nums[i]>(long)2*nums[right]){
                right++;
            }
            cnt+=right-(mid+1);
        }
        return cnt;
    }
    public void merge(int low,int mid,int high,int[] nums){
        int left=low;
        int right=mid+1;
        List<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(nums[left]);
            left++;
        }
        while(right<=high){
            temp.add(nums[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);//as in temp we have 0 ,1,2... but low nd high can be 2 to 4 for ex
        }
    }
}
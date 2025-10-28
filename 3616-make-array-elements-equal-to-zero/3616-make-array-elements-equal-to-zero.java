class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int count=0;
        for (int curr = 0; curr < n; curr++) {
            if(nums[curr]==0){
                boolean val1=isValid(nums,curr,true);
                boolean val2=isValid(nums,curr,false);
                if(val1 && val2)count+=2;
                else if(val1 || val2)count+=1;
            }
        }
        return count;
    }
    public boolean checkNums(int[] nums){
        for(int num:nums){
            if(num>0)return false;
        }
        return true;
    }
    public boolean isValid(int[] nums,int curr,boolean right){
        int[] temp = nums.clone();
        int c=curr;
        int n=temp.length;
        while(c>=0 && c<n){
            if(temp[c]==0 && right){
                c++;
            }
            else if(temp[c]==0 && !right){
                c--;
            }
            else if(temp[c]>0){
                temp[c]--;
                right=!right;
                if(right)c++;
                else c--;
            }
        }
        return checkNums(temp);
    }
}
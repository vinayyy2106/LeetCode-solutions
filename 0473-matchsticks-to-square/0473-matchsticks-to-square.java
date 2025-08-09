class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4)return false;
        int[] list=new int[4];
        int sum=0;
        for(int num:matchsticks)sum+=num;
        if (sum % 4 != 0) return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return helper(matchsticks,list,0,sum/4);
    }
    public boolean helper(int[] matchsticks,int[] li,int idx,int target){
        if(idx==matchsticks.length){
            return li[0]==li[1] && li[1]==li[2] && li[2]==li[3];
        }
        for(int i=0;i<4;i++){
            li[i]+=matchsticks[idx];
            
            if(li[i]<=target && helper(matchsticks,li,idx+1,target)){
                return true;
            }
            li[i]-=matchsticks[idx];
        }
        return false;
    }
    public void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
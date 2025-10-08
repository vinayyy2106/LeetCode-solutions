class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=potions.length;
        int m=spells.length;
        int[] res=new int[m];
        for(int i=0;i<m;i++){
            int start=0;
            int end=n-1;
            int index=n;
            while(start<=end){
                int mid=start+(end-start)/2;
                if((long)potions[mid]*spells[i]>=success){
                    index=mid;
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            res[i]=n-index;
        }
        return res;
    }
}
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int[] res={-1,-1};
        for(int num:nums ){
            if(set.contains(num)){
                if(res[0]==-1){
                    res[0]=num;
                }else{
                    res[1]=num;
                }
                if(res[0]!=-1 && res[1]!=-1)break;
            }
            set.add(num);
        }
        return res;
    }
}
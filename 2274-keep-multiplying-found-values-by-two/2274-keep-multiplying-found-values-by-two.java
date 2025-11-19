class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> st=new HashSet<>();
        for(int num:nums){
            st.add(num);
        }
        while(true){
            if(st.contains(original)){
                original*=2;
            }else{
                break;
            }
        }
        return original;
    }
}
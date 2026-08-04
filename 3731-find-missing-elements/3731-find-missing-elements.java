class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=101;
        int max=0;
        Set<Integer> st=new HashSet<>();
        for(int num:nums){
            min=Math.min(num,min);
            max=Math.max(num,max);
            st.add(num);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!st.contains(i))res.add(i);
        }
        return res;
    }
}
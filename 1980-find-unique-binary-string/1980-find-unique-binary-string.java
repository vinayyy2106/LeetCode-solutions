class Solution {
    int n;
    Set<String> set = new HashSet();
    public String findDifferentBinaryString(String[] nums) {
        n=nums.length;
        for(String s:nums){
            set.add(s);
        }
        return helper("");
    }
    public String helper(String str){
        if(str.length()==n){
            if(!set.contains(str))return str;
            return "";
        }
        String zeroOne=helper(str+'0');
        if(zeroOne.length()>0)return zeroOne;
        return helper(str+'1');

    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<=0)return "";
        String newStr="";
        for(int i=0;i<strs[0].length();i++){
            for(int j=0;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=strs[0].charAt(i))return newStr;
            }
            newStr+=strs[0].charAt(i);
        }
        return newStr;
    }
}
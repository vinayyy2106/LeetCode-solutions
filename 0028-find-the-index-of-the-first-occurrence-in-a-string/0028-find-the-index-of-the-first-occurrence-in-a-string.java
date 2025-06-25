class Solution {
    public int strStr(String haystack, String needle) {
        int i=haystack.indexOf(needle);
        return i==-1?-1:i;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int maxLength=0;
        Map<Character, Integer> num = new HashMap<>();
        while(r<s.length()){
            if(num.containsKey(s.charAt(r)) && num.get(s.charAt(r))>=l){
                l=num.get(s.charAt(r))+1;
            }
            maxLength=Math.max(maxLength,r-l+1);
            num.put(s.charAt(r),r);
            r++;
        }
        return maxLength;
    }
}
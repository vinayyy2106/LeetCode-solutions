class Solution {
    public int lengthOfLongestSubstring(String s) {
         int l=0;
        int r=0;
        int maxLength=0;
        int length=0;
        Map<Character, Integer> num = new HashMap<>();
        while(r<s.length()){
            if(num.containsKey(s.charAt(r))){
                if(num.get(s.charAt(r))>=l){
                    l=num.get(s.charAt(r))+1;
                    
                }
            }
            
                length=r-l+1;
                maxLength=Math.max(length,maxLength);
                num.put(s.charAt(r),r);
                r=r+1;
            
        }
        return maxLength;
    }
}
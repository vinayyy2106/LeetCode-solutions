class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> v = new HashMap<>();
        HashMap<Character, Integer> c = new HashMap<>();
        for(char ch:s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                v.put(ch,v.getOrDefault(ch,0)+1);
            }else{
                c.put(ch,c.getOrDefault(ch,0)+1);
            }
        }
        int maxVow=0;
        int maxCon=0;
        for(char ch:v.keySet()){
            maxVow=Math.max(maxVow,v.get(ch));
        }
        for(char ch:c.keySet()){
            maxCon=Math.max(maxCon,c.get(ch));
        }
        return maxVow+maxCon;
    }
}
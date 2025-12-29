class Solution {
    private Map<String, Boolean> t = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> mp = new HashMap<>();
        for (String pattern : allowed) {
            String pair = pattern.substring(0, 2);
            char top = pattern.charAt(2);
            mp.computeIfAbsent(pair, k -> new ArrayList<>()).add(top);
        }
        return solve(bottom,mp,0,new StringBuilder());
    }
    public boolean solve(String curr,Map<String, List<Character>> mp,int ind,StringBuilder next){
        if(curr.length()==1)return true;
        String key = curr + "_" + ind + "_" + next.toString();
        if (t.containsKey(key)) {
            return t.get(key);
        }
        if(ind==curr.length()-1){
            boolean result= solve(next.toString(),mp,0,new StringBuilder());
            t.put(key,result);
            return result;
        }
        String pair = curr.substring(ind, ind + 2);
        if(!mp.containsKey(pair)){
            t.put(key,false);
            return false;
        }
        for(char ch:mp.get(pair)){
            next.append(ch);
            if (solve(curr, mp, ind + 1, next)){
                t.put(key,true);
                return true;
            }
            next.deleteCharAt(next.length() - 1);
        }
        t.put(key,false);
        return false;
    }
}
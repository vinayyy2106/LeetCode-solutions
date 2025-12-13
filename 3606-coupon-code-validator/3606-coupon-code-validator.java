class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Pair> validPairs=new ArrayList<>();
        List<String> ans=new ArrayList<>();
        int n=code.length;
        for(int i=0;i<n;i++){
            if(isValid(code[i]) && isValidBusiness(businessLine[i]) && isActive[i]==true){
                validPairs.add(new Pair(code[i],businessLine[i]));
            }
        }
        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);
        Collections.sort(validPairs,(a,b)->{
            int p1=priority.get(a.businessLine);
            int p2=priority.get(b.businessLine);
            if(p1!=p2){
                return Integer.compare(p1,p2);
            }
            return a.code.compareTo(b.code);
        });
        for(Pair pair:validPairs){
            ans.add(pair.code);
        }
        return ans;
    }
    public static boolean isValidBusiness(String s){
        return s.equals("electronics") || s.equals("grocery")|| s.equals("pharmacy") || s.equals("restaurant");
    }
    public static boolean isValid(String s) {
        return s!="" && s != null && s.matches("^[a-zA-Z0-9_]+$");
    }
}
class Pair{
    String code;
    String businessLine;
    public Pair(String code,String businessLine){
        this.code=code;
        this.businessLine=businessLine;
    }
}

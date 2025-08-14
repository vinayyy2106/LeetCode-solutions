class Solution {
    public String largestGoodInteger(String num) {
        String temp="000";
        String[] stringArr={"999","888","777","666","555","444","333","222","111"};
        for(String str:stringArr){
            if(num.contains(str) && Integer.parseInt(str)>Integer.parseInt(temp)){
                temp=str;
            }
        }
        return temp.equals("000")?num.contains("000")?"000":"":temp;
    }
}
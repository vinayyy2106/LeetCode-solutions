class Solution {
    public String countAndSay(int n) {
        StringBuilder str=new StringBuilder();
        findRLE(n,str);
        return str.toString();
    }
    public void findRLE(int n, StringBuilder str){
        if(n==1){
            str.append("1");
            return;
        }
       findRLE(n-1,str);
       
        String encoded = findReal(str.toString());
        str.setLength(0);
        str.append(encoded);
       
    }
    public String findReal(String n){
        StringBuilder sb=new StringBuilder();
        int count=1;

        for(int i=1;i<n.length();i++){
            if(n.charAt(i)==n.charAt(i-1)){
                count++;
            }
            else{
                sb.append(count).append(n.charAt(i-1));
                count=1;
            }
        }
        sb.append(count).append(n.charAt(n.length()-1));
        return sb.toString();
    }
}
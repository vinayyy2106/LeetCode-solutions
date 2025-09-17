class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder st=new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            int val=columnNumber%26;
            st.append((char)('A'+val));
            columnNumber=columnNumber/26;
        }
        return st.reverse().toString();
    }
}
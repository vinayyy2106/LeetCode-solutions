class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int l=encodedText.length();
        int cols=l/rows;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<cols;i++){
            for(int j=i;j<l;j+=(cols+1)){
                str.append(encodedText.charAt(j));
            }
        }
        int end = str.length() - 1;
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        return str.substring(0, end + 1);
    }
}
class Solution {
    public int minOperations(String s) {
        return Math.min(helper(s), 1+helper(flipFirst(s)));
    }

    private int helper(String s){
        int n = s.length();
        if(n == 1) return 0;

        int count = 0;
        char[] charArr = s.toCharArray();

        for(int i = 1; i < charArr.length; i++){
            char ch = charArr[i];
            char ch2 = charArr[i-1];

            if((ch=='1' && ch2=='0') || (ch=='0' && ch2=='1')){
                continue;
            }else{
                count++;
                charArr[i] = (ch2=='0') ? '1' : '0';
            }
        }

        return count;
    }

    private String flipFirst(String s){
        char[] arr = s.toCharArray();
        arr[0] = (arr[0]=='0') ? '1' : '0';
        return new String(arr);
    }
}
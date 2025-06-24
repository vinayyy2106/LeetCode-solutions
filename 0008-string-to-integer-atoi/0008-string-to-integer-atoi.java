class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1;
        int index = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        // Call recursive parsing
        return integerOfS(s, 0, index, sign);
    }

    static int integerOfS(String A, int num, int i, int sign) {
        if (i >= A.length() || !Character.isDigit(A.charAt(i))) return num * sign;
        int digit = A.charAt(i) - '0';
        if (num > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return integerOfS(A, num * 10 + digit, i + 1, sign);
    }
}

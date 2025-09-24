class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder result = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        long num=Math.abs((long)numerator);
        long den=Math.abs((long)denominator);
        result.append(num/den); //appending the integer part ex: 2/5=0
        long rem=num%den;
        if(rem==0)return result.toString();
        result.append(".");
        Map<Long,Integer> mp=new HashMap<>();//to store remainder and particular index 
        //imp: rem repeats with the reoccuring decimal
        while(rem!=0){
            if(mp.containsKey(rem)){
                int idx = mp.get(rem);
                result.insert(idx, "(");
                result.append(")");
                break;
            }
            mp.put(rem,result.length());
            rem*=10;
            result.append(rem/den);
            rem%=den;

        }
        return result.toString();
    }
}
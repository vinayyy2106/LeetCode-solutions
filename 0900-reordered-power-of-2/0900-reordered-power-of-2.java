class Solution {
    public boolean reorderedPowerOf2(int n) {
        String tar=String.valueOf(n);
        for(int i=0;i<32;i++){
            int num=(1<<i);
            if(sort(num).equals(tar))return true;
        }
        return false;
    }
    public String sort(int val){
        char[] charArray=String.valueOf(val).toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

}
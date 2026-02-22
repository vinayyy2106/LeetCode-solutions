class Solution {
    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        int len=binaryString.length();
        int index=-1;
        int max=0;
        for(int i=0;i<len;i++){
            if(binaryString.charAt(i)=='1'){
                index=i;
                break;
            }
        }
        if(index==len-1)return 0;
        int l=index;
        int r=index;
        while(r<len){
            if(r!=l && binaryString.charAt(r)=='1'){
                max=Math.max(max,r-l);
                l=r;
            }  
            r++;
        }
        return max;
    }
}